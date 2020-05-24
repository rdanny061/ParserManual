import AST.*;
import AST.PrimaryExpression.*;
import AST.SingleCommand.*;
import AST.SingleDeclaration.*;
import Tools.AContextual;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;

public class Parser1 {
    Scanner1 lexer;
    Token currentToken;
    Boolean successful = true;

    public Parser1(Scanner1 lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.getToken();
    }

    CommonToken accept(int expectedToken) {
        CommonToken current = (CommonToken) currentToken;
        if (currentToken.getType() == expectedToken) {
            currentToken = lexer.nextToken();
        } else {
            this.printError();
        }
        return current;
    }

    void acceptIt() {
        currentToken = lexer.nextToken();
    }

    AST parse() {
        acceptIt();
        return parseProgram();
    }

    AST parseProgram() {
        ProgramAST node;
        SingleCommandAST scast = parseSingleCommand();
        node = new ProgramAST(scast, (CommonToken) currentToken);
        AContextual aContextual = new AContextual();
        node.visit(aContextual);
        return node;
    }

    CommandAST parseCommand() {
        CommandAST node;
        SingleCommandAST scast = parseSingleCommand();
        ArrayList<SingleCommandAST> singleCommandList = new ArrayList<SingleCommandAST>();
        ArrayList<CommonToken> PyCOMAList = new ArrayList<CommonToken>();
        while (currentToken.getType() == Scanner1.PyCOMA) {
            PyCOMAList.add(accept(Scanner1.PyCOMA));
            singleCommandList.add(parseSingleCommand());
        }
        node = new CommandAST(scast, singleCommandList, PyCOMAList);
        return node;
    }

    SingleCommandAST parseSingleCommand() {
        SingleCommandAST node = null;
        if (currentToken.getType() == Scanner1.IDENT) {
            CommonToken ident = (CommonToken) currentToken;
            acceptIt();
            if (currentToken.getType() == Scanner1.ASSIGN) {
                CommonToken assign = (CommonToken) currentToken;
                acceptIt();
                ExpressionAST expression = parseExpression();
                node = new AssignSCAST(ident, assign, expression);
            } else if (currentToken.getType() == Scanner1.PIZQ) {
                CommonToken pizq = (CommonToken) currentToken;
                acceptIt();
                ExpressionAST expression = parseExpression();
                CommonToken pder = accept(Scanner1.PDER);
                node = new CallFunctionSCAST(ident, pizq, expression, pder);
            } else {
                this.printError();
            }
        } else if (currentToken.getType() == Scanner1.IF) {
            CommonToken If = (CommonToken) currentToken;
            acceptIt();
            ExpressionAST expression = parseExpression();
            CommonToken then = accept(Scanner1.THEN);
            SingleCommandAST singleCommandTHEN = parseSingleCommand();
            CommonToken Else = accept(Scanner1.ELSE);
            SingleCommandAST singleCommandELSE = parseSingleCommand();
            node = new IFSCAST(If, expression, then, singleCommandTHEN, Else, singleCommandELSE);
        } else if (currentToken.getType() == Scanner1.WHILE) {
            CommonToken While = (CommonToken) currentToken;
            acceptIt();
            ExpressionAST expression = parseExpression();
            CommonToken Do = accept(Scanner1.DO);
            SingleCommandAST singleCommand = parseSingleCommand();
            node = new WHILESCAST(While, expression, Do, singleCommand);
        } else if (currentToken.getType() == Scanner1.LET) {
            CommonToken Let = (CommonToken) currentToken;
            acceptIt();
            DeclarationAST declaration = parseDeclaration();
            CommonToken In = accept(Scanner1.IN);
            SingleCommandAST singleCommand = parseSingleCommand();
            node = new LETSCAST(Let, declaration, In, singleCommand);
        } else if (currentToken.getType() == Scanner1.BEGIN) {
            CommonToken Begin = (CommonToken) currentToken;
            acceptIt();
            CommandAST command = parseCommand();
            CommonToken End = accept(Scanner1.END);
            node = new BLOCKSCAST(Begin, command, End);
        } else {
            this.printError();
        }
        return node;
    }

    DeclarationAST parseDeclaration() {
        DeclarationAST node;
        SingleDeclarationAST singleDeclaration = parseSingleDeclaration();
        ArrayList<SingleDeclarationAST> singleDeclarationList = new ArrayList<SingleDeclarationAST>();
        ArrayList<CommonToken> PyCOMAList = new ArrayList<CommonToken>();
        while (currentToken.getType() == Scanner1.PyCOMA) {
            PyCOMAList.add(accept(Scanner1.PyCOMA));
            singleDeclarationList.add(parseSingleDeclaration());
        }
        node = new DeclarationAST(singleDeclaration, singleDeclarationList, PyCOMAList);
        return node;
    }

    SingleDeclarationAST parseSingleDeclaration() {
        SingleDeclarationAST node = null;
        if (currentToken.getType() == Scanner1.CONST) {
            CommonToken Const = (CommonToken) currentToken;
            acceptIt();
            CommonToken ident = accept(Scanner1.IDENT);
            CommonToken vir = accept(Scanner1.VIR);
            ExpressionAST expression = parseExpression();
            node = new CONSTSDAST(Const, ident, vir, expression);
        } else if (currentToken.getType() == Scanner1.VAR) {
            CommonToken Var = (CommonToken) currentToken;
            acceptIt();
            CommonToken ident = accept(Scanner1.IDENT);
            CommonToken dospun = accept(Scanner1.DOSPUN);
            TypeDenoterAST typeDenoter = parseTypeDenoter();
            node = new VARSDAST(Var, ident, dospun, typeDenoter);
        } else {
            printError();
        }
        return node;
    }

    TypeDenoterAST parseTypeDenoter() {
        TypeDenoterAST node = new TypeDenoterAST(accept(Scanner1.IDENT));
        return node;
    }

    ExpressionAST parseExpression() {
        ExpressionAST node;
        PrimaryExpressionAST primaryExpression = parsePrimaryExpression();
        ArrayList<PrimaryExpressionAST> primaryExpressionList = new ArrayList<PrimaryExpressionAST>();
        ArrayList<OperatorAST> operatorList = new ArrayList<OperatorAST>();
        while (currentToken.getType() == Scanner1.SUM || currentToken.getType() == Scanner1.SUB || currentToken.getType() == Scanner1.MUL || currentToken.getType() == Scanner1.DIV) {
            operatorList.add(new OperatorAST((CommonToken) currentToken));
            acceptIt();
            primaryExpressionList.add(parsePrimaryExpression());
        }
        node = new ExpressionAST(primaryExpression, primaryExpressionList, operatorList);
        return node;
    }

    PrimaryExpressionAST parsePrimaryExpression() {
        PrimaryExpressionAST node = null;
        if (currentToken.getType() == Scanner1.NUM) {
            node = new NUMPEAST((CommonToken) currentToken);
            acceptIt();
        } else if (currentToken.getType() == Scanner1.IDENT) {
            node = new IDENTPEAST((CommonToken) currentToken);
            acceptIt();
        } else if (currentToken.getType() == Scanner1.PIZQ) {
            CommonToken pizq = (CommonToken) currentToken;
            acceptIt();
            ExpressionAST expression = parseExpression();
            CommonToken pder = accept(Scanner1.PDER);
            node = new GROUPPEAST(pizq, expression, pder);
        } else {
            this.printError();
        }
        return node;
    }

    void printError() {
        if (this.successful) {
            System.out.println("Error, no se esperaba '" + currentToken.getText() + "' en la linea " + currentToken.getLine() + " posición " + currentToken.getCharPositionInLine() + ".");
            this.successful = false;
        }
    }
}