package stone.ast;

import stone.env.Environment;

import java.util.List;

public class VarNode extends AstList {
    public VarNode(List<AstTree> c) { super(c); }
    public String name() { return ((AstLeaf)child(0)).token().getText(); }
    public TypeTag type() { return (TypeTag)child(1); }
    public AstTree initializer() { return child(2); }
    public String toString() {
        return "(var " + name() + " " + type() + " " + initializer() + ")";
    }
    @Override
    public Object eval(Environment e) {
        return null;
    }
}
