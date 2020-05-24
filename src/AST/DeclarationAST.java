package AST;

import Tools.Visitor;
import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;
import java.util.List;

public class DeclarationAST extends AST {
    public SingleDeclarationAST singleDeclaration;
    public ArrayList<SingleDeclarationAST> singleDeclarationList;
    public ArrayList<CommonToken> PyCOMAList;

    public DeclarationAST(SingleDeclarationAST singleDeclaration, ArrayList<SingleDeclarationAST> singleDeclarationList, ArrayList<CommonToken> pyCOMAList) {
        this.singleDeclaration = singleDeclaration;
        this.singleDeclarationList = singleDeclarationList;
        PyCOMAList = pyCOMAList;
    }

    @Override
    public void visit(Visitor v) {
        v.visitDeclaration(this);
    }
}
