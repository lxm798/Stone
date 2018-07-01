package stone.parse;

import stone.Lexer;
import stone.NumToken;
import stone.ast.AstTree;
import stone.ast.NumNode;
import stone.element.Element;
import stone.element.OrElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public  class Parser {
    protected List<Element> elements;
    public AstTree parse(Lexer lexer) {

    }
    public Parser(Class<? extends AstTree> clazz) {
        reset(clazz);
    }
    protected Parser(Parser p) {
        elements = p.elements;
    }
    public AstTree parse(Lexer lexer) throws ParseException {
        ArrayList<AstTree> results = new ArrayList<AstTree>();
        for (Element e: elements)
            e.parse(lexer, results);

        return factory.make(results);
    }
    protected boolean match(Lexer lexer) throws ParseException {
        if (elements.size() == 0)
            return true;
        else {
            Element e = elements.get(0);
            return e.match(lexer);
        }
    }
    public static Parser rule() { return rule(null); }
    public static Parser rule(Class<? extends AstTree> clazz) {
        return new Parser(clazz);
    }
    public Parser reset() {
        elements = new ArrayList<>();
        return this;
    }
    public Parser number() {
        return number(null);
    }
    public Parser number(Class<? extends ASTLeaf> clazz) {
        elements.add(new NumNode(clazz));
        return this;
    }
    public Parser identifier(HashSet<String> reserved) {
        return identifier(null, reserved);
    }
    public Parser identifier(Class<? extends ASTLeaf> clazz,
                             HashSet<String> reserved)
    {
        elements.add(new IdToken(clazz, reserved));
        return this;
    }
    public Parser string() {
        return string(null);
    }
    public Parser string(Class<? extends ASTLeaf> clazz) {
        elements.add(new StrToken(clazz));
        return this;
    }
    public Parser token(String... pat) {
        elements.add(new Leaf(pat));
        return this;
    }
    public Parser sep(String... pat) {
        elements.add(new Skip(pat));
        return this;
    }
    public Parser ast(Parser p) {
        elements.add(new Tree(p));
        return this;
    }
    public Parser or(Parser... p) {
        elements.add(new OrElement(p));
        return this;
    }
    public Parser maybe(Parser p) {
        Parser p2 = new Parser(p);
        p2.reset();
        elements.add(new OrTree(new Parser[] { p, p2 }));
        return this;
    }
    public Parser option(Parser p) {
        elements.add(new Repeat(p, true));
        return this;
    }
    public Parser repeat(Parser p) {
        elements.add(new Repeat(p, false));
        return this;
    }
    public Parser expression(Parser subexp, Operators operators) {
        elements.add(new Expr(null, subexp, operators));
        return this;
    }
    public Parser expression(Class<? extends AstTree> clazz, Parser subexp,
                             Operators operators) {
        elements.add(new Expr(clazz, subexp, operators));
        return this;
    }
    public Parser insertChoice(Parser p) {
        Element e = elements.get(0);
        if (e instanceof OrTree)
            ((OrTree)e).insert(p);
        else {
            Parser otherwise = new Parser(this);
            reset(null);
            or(p, otherwise);
        }
        return this;
    }
}
