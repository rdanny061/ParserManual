package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class WHILESCAST extends SingleCommandAST {
    public CommonToken WHILE;
    public ExpressionAST expression;
    public CommonToken DO;
    public SingleCommandAST singleCommand;

    public WHILESCAST(CommonToken WHILE, ExpressionAST expression, CommonToken DO, SingleCommandAST singleCommand) {
        this.WHILE = WHILE;
        this.expression = expression;
        this.DO = DO;
        this.singleCommand = singleCommand;
    }

    @Override
    public void visit(Visitor v) {
        v.visitWHILESC(this);
    }
}
