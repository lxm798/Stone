package stone.ast;

import java.util.ArrayList;

public abstract class AstTree {
    private ArrayList<AstTree> childrens = null;

    public AstTree getChild(int i) {
        return childrens.get(i);
    }

    abstract public void eval();
}
