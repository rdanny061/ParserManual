package AST.PrimaryExpression;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class GROUPPEAST extends PrimaryExpressionAST {
    public CommonToken PIZQ;
    public ExpressionAST expression;
    public CommonToken PDER;

    public GROUPPEAST(CommonToken PIZQ, ExpressionAST expression, CommonToken PDER) {
        this.PIZQ = PIZQ;
        this.expression = expression;
        this.PDER = PDER;
    }

    @Override
    public void visit(Visitor v) {
        v.visitGROUPPE(this);
    }
}
