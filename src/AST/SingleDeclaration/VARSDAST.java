package AST.SingleDeclaration;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class VARSDAST extends SingleDeclarationAST {
    public CommonToken VAR;
    public CommonToken IDENT;
    public CommonToken DOSPUN;
    public TypeDenoterAST typeDenoter;

    public VARSDAST(CommonToken VAR, CommonToken IDENT, CommonToken DOSPUN, TypeDenoterAST typeDenoter) {
        this.VAR = VAR;
        this.IDENT = IDENT;
        this.DOSPUN = DOSPUN;
        this.typeDenoter = typeDenoter;
    }

    @Override
    public void visit(Visitor v) {
        v.visitVARSD(this);
    }
}
