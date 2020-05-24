package Tools;

import AST.*;
import AST.SingleCommand.*;
import AST.PrimaryExpression.*;
import AST.SingleDeclaration.*;

public interface Visitor {
    public Object visitGROUPPE(GROUPPEAST ctx);
    public Object visitIDENTPE(IDENTPEAST ctx);
    public Object visitNUMPE(NUMPEAST ctx);
    public Object visitAssignSC(AssignSCAST ctx);
    public Object visitBLOCKSC(BLOCKSCAST ctx);
    public Object visitCallFunctionSC(CallFunctionSCAST ctx);
    public Object visitIFSC(IFSCAST ctx);
    public Object visitLETSC(LETSCAST ctx);
    public Object visitWHILESC(WHILESCAST ctx);
    public Object visitCONSTSD(CONSTSDAST ctx);
    public Object visitVARSD(VARSDAST ctx);
    public Object visitCommand(CommandAST ctx);
    public Object visitDeclaration(DeclarationAST ctx);
    public Object visitExpression(ExpressionAST ctx);
    public Object visitOperator(OperatorAST ctx);
    public Object visitProgram(ProgramAST ctx);
    public Object visitTypeDenoter(TypeDenoterAST ctx);
}
