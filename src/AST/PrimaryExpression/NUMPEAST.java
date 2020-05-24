package AST.PrimaryExpression;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class NUMPEAST extends PrimaryExpressionAST {
    public CommonToken NUM;

    public NUMPEAST(CommonToken NUM) {
        this.NUM = NUM;
    }

    @Override
    public void visit(Visitor v) {
        v.visitNUMPE(this);
    }
}
