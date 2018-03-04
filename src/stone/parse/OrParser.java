package stone.parse;

import stone.Lexer;
import stone.Token;
import stone.ast.AstTree;

import java.util.ArrayList;
import java.util.List;

public class OrParser extends Parser {
    List<Parser> parsers = new ArrayList<>();
    public void addParser(Parser parser) {
        parsers.add(parser);
    }
    @Override
    public AstTree parse(Lexer lexer) {
        for (Parser parser : parsers) {
            AstTree ret = parser.parse(lexer);
            if (ret != null) {
                return ret;
            }
        }
        return null;
    }
}
