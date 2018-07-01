package stone.ast;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AstTree {
    protected ArrayList<AstTree> children = null;

    public AstTree getChild(int i) {
        return children.get(i);
    }

    public Iterator<AstTree> children() {
        return children.iterator();
    }
}
