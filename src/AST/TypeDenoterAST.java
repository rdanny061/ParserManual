package AST;

import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class TypeDenoterAST extends AST {
    public CommonToken IDENT;

    public TypeDenoterAST(CommonToken IDENT) {
        this.IDENT = IDENT;
    }

    @Override
    public void visit(Visitor v) {
        v.visitTypeDenoter(this);
    }
}
