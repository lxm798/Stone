package stone.parse;

import stone.Lexer;
import stone.Token;
import stone.ast.AstTree;

public abstract class Parser {
    abstract public AstTree parse(Lexer token);
    public void or(Parser parser) {

    }
}