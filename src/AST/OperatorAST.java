package AST;

import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class OperatorAST extends AST{
    public CommonToken operator;

    public OperatorAST(CommonToken operator) {
        this.operator = operator;
    }

    @Override
    public void visit(Visitor v) {
        v.visitOperator(this);
    }
}
