lexer grammar Scanner1;

//símbolos
PyCOMA  : ';' ;
ASSIGN  : ':=';
PIZQ    : '(';
PDER    : ')';
VIR     : '~';
DOSPUN  : ':';
SUM     : '+';
SUB     : '-';
MUL     : '*';
DIV     : '/';

//palabras reservadas
IF      : 'if' ;
WHILE   : 'while' ;
LET     : 'let';
THEN    : 'then';
ELSE    : 'else';
IN      : 'in';
DO      : 'do';
BEGIN   : 'begin';
END     : 'end';
CONST   : 'const';
VAR     : 'var';

NUM : [1-9][0-9]* | [0-9];
IDENT : [a-z]([a-z]|[0-9])*;

WS  :   [ \t\n\r]+ -> skip ;