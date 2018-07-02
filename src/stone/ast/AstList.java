package stone.ast;

import stone.StoneException;
import stone.env.Environment;

import java.util.List;

public class AstList extends AstTree {
    public AstList(List<AstTree> c) {
        super();
        children.addAll(c);
    }

    public AstTree child(int i) {
        throw new IndexOutOfBoundsException();
    }
    @Override
    public Object eval(Environment e) {
        throw new StoneException("cannot eval: " + toString());
    }
}
