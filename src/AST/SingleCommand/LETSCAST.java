package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class LETSCAST extends SingleCommandAST {
    public CommonToken LET;
    public DeclarationAST declaration;
    public CommonToken IN;
    public SingleCommandAST singleCommand;

    public LETSCAST(CommonToken LET, DeclarationAST declaration, CommonToken IN, SingleCommandAST singleCommand) {
        this.LET = LET;
        this.declaration = declaration;
        this.IN = IN;
        this.singleCommand = singleCommand;
    }

    @Override
    public void visit(Visitor v) {
        v.visitLETSC(this);
    }
}
