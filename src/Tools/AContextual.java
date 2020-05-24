package Tools;

import AST.*;
import AST.SingleCommand.*;
import AST.SingleDeclaration.*;
import AST.PrimaryExpression.*;
import org.antlr.v4.runtime.CommonToken;


public class AContextual implements Visitor {

    int tabCount = 0;

    @Override
    public Object visitGROUPPE(GROUPPEAST ctx) {
        System.out.print(ctx.PIZQ.getText());
        ctx.expression.visit(this);
        System.out.print(ctx.PDER.getText());
        return null;
    }

    @Override
    public Object visitIDENTPE(IDENTPEAST ctx) {
        System.out.print(ctx.IDENT.getText());
        return null;
    }

    @Override
    public Object visitNUMPE(NUMPEAST ctx) {
        System.out.print(ctx.NUM.getText());
        return null;
    }

    @Override
    public Object visitAssignSC(AssignSCAST ctx) {
        System.out.print(printTabs() + ctx.IDENT.getText());
        System.out.print(" " + ctx.ASSIGN.getText() + " ");
        ctx.expression.visit(this);
        return null;
    }

    @Override
    public Object visitBLOCKSC(BLOCKSCAST ctx) {
        System.out.println(printTabs() + ctx.BEGIN.getText());
        tabCount++;
        ctx.command.visit(this);
        tabCount--;
        System.out.println("\n" + printTabs() + ctx.END.getText());
        return null;
    }

    @Override
    public Object visitCallFunctionSC(CallFunctionSCAST ctx) {
        System.out.print(printTabs() + ctx.IDENT.getText());
        System.out.print(ctx.PIZQ.getText());
        ctx.expression.visit(this);
        System.out.print(ctx.PDER.getText());
        return null;
    }

    @Override
    public Object visitIFSC(IFSCAST ctx) {
        System.out.print(printTabs() + ctx.IF.getText() + " ");
        ctx.expression.visit(this);
        System.out.println(" " + ctx.THEN.getText());
        tabCount++;
        ctx.singleCommandTHEN.visit(this);
        tabCount--;
        System.out.println("\n"+ printTabs() + ctx.ELSE.getText());
        tabCount++;
        ctx.singleCommandELSE.visit(this);
        tabCount--;
        return null;
    }

    @Override
    public Object visitLETSC(LETSCAST ctx) {
        System.out.println(printTabs() + ctx.LET.getText());
        tabCount++;
        ctx.declaration.visit(this);
        System.out.println();
        tabCount--;
        System.out.println(printTabs() + ctx.IN.getText());
        ctx.singleCommand.visit(this);
        return null;
    }

    @Override
    public Object visitWHILESC(WHILESCAST ctx) {
        System.out.print(printTabs() + ctx.WHILE.getText() + " ");
        ctx.expression.visit(this);
        System.out.println(" " + ctx.DO.getText());
        tabCount++;
        ctx.singleCommand.visit(this);
        tabCount--;
        return null;
    }

    @Override
    public Object visitCONSTSD(CONSTSDAST ctx) {
        System.out.print(printTabs() + ctx.CONST.getText() + " ");
        System.out.print(ctx.IDENT.getText() + " ");
        System.out.print(ctx.VIR.getText() + " ");
        ctx.expression.visit(this);
        return null;
    }

    @Override
    public Object visitVARSD(VARSDAST ctx) {
        System.out.print(printTabs() + ctx.VAR.getText() + " ");
        System.out.print(ctx.IDENT.getText() + " ");
        System.out.print(ctx.DOSPUN.getText() + " ");
        ctx.typeDenoter.visit(this);
        return null;
    }

    @Override
    public Object visitCommand(CommandAST ctx) {
        ctx.singleCommand.visit(this);
        for (int i = 0; i < ctx.singleCommandList.size(); i++) {
            System.out.println(ctx.PyCOMAList.get(i).getText());
            ctx.singleCommandList.get(i).visit(this);
        }
        return null;
    }

    @Override
    public Object visitDeclaration(DeclarationAST ctx) {
        ctx.singleDeclaration.visit(this);
        for (int i = 0; i < ctx.singleDeclarationList.size(); i++) {
            System.out.println(ctx.PyCOMAList.get(i).getText());
            ctx.singleDeclarationList.get(i).visit(this);
        }
        return null;
    }

    @Override
    public Object visitExpression(ExpressionAST ctx) {
        ctx.primaryExpression.visit(this);
        for (int i = 0; i < ctx.operatorList.size(); i++) {
            ctx.operatorList.get(i).visit(this);
            ctx.primaryExpressionList.get(i).visit(this);
        }
        return null;
    }

    @Override
    public Object visitOperator(OperatorAST ctx) {
        System.out.print(" " + ctx.operator.getText() + " ");
        return null;
    }

    @Override
    public Object visitProgram(ProgramAST ctx) {
        ctx.singleCommand.visit(this);
        return null;
    }

    @Override
    public Object visitTypeDenoter(TypeDenoterAST ctx) {
        System.out.print(ctx.IDENT.getText());
        return null;
    }

    public String printTabs(){
        String tabs = "";
        for (int i = 0; i < tabCount; i++) {
            tabs+="\t";
        }
        return tabs;
    }
}
