package stone.ast;

import stone.Token;
import stone.env.Environment;

public class StringNode extends AstLeaf {

    public StringNode(Token t) {
        super(t);
    }

    @Override
    public Object eval(Environment e) {
        return token.getText();
    }
}
