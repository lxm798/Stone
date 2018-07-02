package stone.ast;

import stone.Token;

public abstract class AstLeaf extends AstTree {
    protected Token token;

    public AstLeaf(Token t) {
        token = t;
    }

    public AstTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int numChildren() {
        return 0;
    }

    public String toString() {
        return token.getText();
    }

    public String location() {
        return "line :" + token.getLineNumber();
    }

    public Token token() {
        return token;
    }
}
