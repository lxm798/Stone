package stone.element;


import stone.Lexer;
import stone.Token;
import stone.ast.AstTree;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leaf extends Element {
    private String[] strs;
    public Leaf(String... args) {
        Arrays.sort(args);
        strs = args;
    }

    @Override
    public void parse(Lexer lexer, List<AstTree> res) throws ParseException {

    }

    @Override
    public boolean match(Lexer lexer) throws ParseException {
        Token t = null;
        while ((t = lexer.read()) != null) {
            while (Arrays.binarySearch(strs, t.getText()) == -1) {
                return false;
            }
        }
        return true;
    }
}
