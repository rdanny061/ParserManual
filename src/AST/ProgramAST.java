package AST;

import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class ProgramAST extends AST {
    public SingleCommandAST singleCommand;
    public CommonToken EOF;

    public ProgramAST(SingleCommandAST singleCommand, CommonToken EOF) {
        this.singleCommand = singleCommand;
        this.EOF = EOF;
    }

    @Override
    public void visit(Visitor v) {
        v.visitProgram(this);
    }
}
