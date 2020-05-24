package AST.SingleDeclaration;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class CONSTSDAST extends SingleDeclarationAST {
    public CommonToken CONST;
    public CommonToken IDENT;
    public CommonToken VIR;
    public ExpressionAST expression;

    public CONSTSDAST(CommonToken CONST, CommonToken IDENT, CommonToken VIR, ExpressionAST expression) {
        this.CONST = CONST;
        this.IDENT = IDENT;
        this.VIR = VIR;
        this.expression = expression;
    }

    @Override
    public void visit(Visitor v) {
        v.visitCONSTSD(this);
    }
}
