package stone.ast;

import stone.NumToken;

public class NumNode extends AstTree {
    private NumToken numToken = null;

    public NumNode(NumToken token) {
        numToken = token;
    }

    public Integer getNum() {
        return numToken.getNumber();
    }
}
