package stone.element;

import stone.Lexer;
import stone.ast.AstTree;
import stone.parse.Parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrElement extends Element{

    public OrElement(Parser... parses) {
        this.parsers.addAll(Arrays.asList(parses));
    }
    ArrayList<Parser> parsers;
    @Override
    public void parse(Lexer lexer, List<AstTree> res) throws ParseException {

    }

    @Override
    public boolean match(Lexer lexer) throws ParseException {
        return false;
    }

    public void insert(Parser parser) {
        parsers.add(parser);
    }
}
