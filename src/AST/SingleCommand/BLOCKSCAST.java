package AST.SingleCommand;

import AST.*;
import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

public class BLOCKSCAST extends SingleCommandAST {
    public CommonToken BEGIN;
    public CommandAST command;
    public CommonToken END;

    public BLOCKSCAST(CommonToken BEGIN, CommandAST command, CommonToken END) {
        this.BEGIN = BEGIN;
        this.command = command;
        this.END = END;
    }
    @Override
    public void visit(Visitor v) {
        v.visitBLOCKSC(this);
    }
}
