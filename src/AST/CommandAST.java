package AST;

import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;

public class CommandAST extends AST {
    public SingleCommandAST singleCommand;
    public ArrayList<SingleCommandAST> singleCommandList;
    public ArrayList<CommonToken> PyCOMAList;

    public CommandAST(SingleCommandAST singleCommand, ArrayList<SingleCommandAST> singleCommandList, ArrayList<CommonToken> pyCOMAList) {
        this.singleCommand = singleCommand;
        this.singleCommandList = singleCommandList;
        PyCOMAList = pyCOMAList;
    }

    @Override
    public void visit(Visitor v) {
        v.visitCommand(this);
    }
}
