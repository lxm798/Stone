package stone.element;

import stone.Lexer;
import stone.ast.AstList;
import stone.ast.AstTree;
import stone.parse.Parser;

import java.text.ParseException;
import java.util.List;

public class Repeat extends Element {
    protected Parser parser;
    protected boolean onlyOnce;
    public Repeat(Parser p, boolean once) { parser = p; onlyOnce = once; }
    public void parse(Lexer lexer, List<AstTree> res)
            throws ParseException
    {
        while (parser.match(lexer)) {
            AstTree t = parser.parse(lexer);
            if (t.getClass() != AstList.class || t.numChildren() > 0)
                res.add(t);
            if (onlyOnce)
                break;
        }
    }
    public boolean match(Lexer lexer) throws ParseException {
        return parser.match(lexer);
    }
}
