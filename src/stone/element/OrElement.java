package stone.element;

import stone.Lexer;
import stone.ast.AstTree;
import stone.parse.Parser;

import java.text.ParseException;
import java.util.List;

public class OrElement extends Element{

    public OrElement(Parser... parses) {
        this.parsers = parses;
    }
    Parser[] parsers;
    @Override
    protected void parse(Lexer lexer, List<AstTree> res) throws ParseException {

    }

    @Override
    protected boolean match(Lexer lexer) throws ParseException {
        return false;
    }
}