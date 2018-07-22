package stone.element;

import stone.Lexer;
import stone.Token;
import stone.ast.AstTree;
import stone.parse.Parser;

import java.text.ParseException;
import java.util.List;

public class Tree extends Element{
    Parser parser;
    public Tree(Parser parser) {
        this.parser = parser;
    }
    @Override
    public void parse(Lexer lexer, List<AstTree> res) throws ParseException {
        res.add(parser.parse(lexer));
    }

    @Override
    public boolean match(Lexer lexer) throws ParseException {
        return parser.match(lexer);
    }
}
