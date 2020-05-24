package AST;

import Tools.Visitor;

public abstract class AST {
    public abstract void visit(Visitor v);
}
