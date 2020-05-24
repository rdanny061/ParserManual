package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class CallFunctionSCAST extends SingleCommandAST {
    public CommonToken IDENT;
    public CommonToken PIZQ;
    public ExpressionAST expression;
    public CommonToken PDER;

    public CallFunctionSCAST(CommonToken IDENT, CommonToken PIZQ, ExpressionAST expression, CommonToken PDER) {
        this.IDENT = IDENT;
        this.PIZQ = PIZQ;
        this.expression = expression;
        this.PDER = PDER;
    }
    @Override
    public void visit(Visitor v) {
        v.visitCallFunctionSC(this);
    }
}
