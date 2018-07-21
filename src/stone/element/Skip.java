package stone.element;

import stone.Lexer;
import stone.ast.AstTree;

import java.text.ParseException;
import java.util.List;

public class Skip extends Leaf {
    private String[] strs;

    public Skip(String... strs) {
        super(strs);
    }
}
