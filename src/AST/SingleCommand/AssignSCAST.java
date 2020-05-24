package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class AssignSCAST extends SingleCommandAST {
    public CommonToken IDENT;
    public CommonToken ASSIGN;
    public ExpressionAST expression;

    public AssignSCAST(CommonToken IDENT, CommonToken ASSIGN, ExpressionAST expression) {
        this.IDENT = IDENT;
        this.ASSIGN = ASSIGN;
        this.expression = expression;
    }

    @Override
    public void visit(Visitor v) {
        v.visitAssignSC(this);
    }
}
