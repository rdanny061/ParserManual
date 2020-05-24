package AST;

import Tools.Visitor;

import java.util.ArrayList;

public class ExpressionAST extends AST {
    public PrimaryExpressionAST primaryExpression;
    public ArrayList<PrimaryExpressionAST> primaryExpressionList;
    public ArrayList<OperatorAST> operatorList;

    public ExpressionAST(PrimaryExpressionAST primaryExpression, ArrayList<PrimaryExpressionAST> primaryExpressionList, ArrayList<OperatorAST> operatorList) {
        this.primaryExpression = primaryExpression;
        this.primaryExpressionList = primaryExpressionList;
        this.operatorList = operatorList;
    }

    @Override
    public void visit(Visitor v) {
        v.visitExpression(this);
    }
}
