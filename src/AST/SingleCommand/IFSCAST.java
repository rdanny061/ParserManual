package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class IFSCAST extends SingleCommandAST {
    public CommonToken IF;
    public ExpressionAST expression;
    public CommonToken THEN;
    public SingleCommandAST singleCommandTHEN;
    public CommonToken ELSE;
    public SingleCommandAST singleCommandELSE;

    public IFSCAST(CommonToken IF, ExpressionAST expression, CommonToken THEN, SingleCommandAST singleCommandTHEN, CommonToken ELSE, SingleCommandAST singleCommandELSE) {
        this.IF = IF;
        this.expression = expression;
        this.THEN = THEN;
        this.singleCommandTHEN = singleCommandTHEN;
        this.ELSE = ELSE;
        this.singleCommandELSE = singleCommandELSE;
    }

    @Override
    public void visit(Visitor v) {
        v.visitIFSC(this);
    }
}
