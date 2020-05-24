package AST.PrimaryExpression;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class IDENTPEAST extends PrimaryExpressionAST {
    public CommonToken IDENT;

    public IDENTPEAST(CommonToken IDENT) {
        this.IDENT = IDENT;
    }

    @Override
    public void visit(Visitor v) {
        v.visitIDENTPE(this);
    }
}
