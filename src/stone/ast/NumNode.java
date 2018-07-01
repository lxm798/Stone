package stone.ast;

import stone.NumToken;

public class NumNode extends AstLeaf {
    private NumToken numToken = null;

    public NumNode(NumToken token) {
        super(token);
        numToken = token;
    }

    public Integer getNum() {
        return numToken.getNumber();
    }
}
