package stone.element;

import stone.Lexer;
import stone.ast.AstTree;

import java.text.ParseException;
import java.util.List;

public abstract class Element {
    public abstract void parse(Lexer lexer, List<AstTree> res)
            throws ParseException;

    public abstract boolean match(Lexer lexer) throws ParseException;
}
