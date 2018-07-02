package stone.ast;

import stone.env.Environment;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AstTree {
    protected ArrayList<AstTree> children = new ArrayList<>();

    public AstTree child(int i) {
        return children.get(i);
    }

    public int numChildren() {
        return children.size();
    }

    public Iterator<AstTree> children() {
        return children.iterator();
    }

    public abstract Object eval(Environment e);
}
