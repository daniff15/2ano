grammar Calculator;

program: stat* EOF;
stat : expr? NEWLINE 
    | assignment ;
assignment : ID '=' expr; 
expr: op=('+'|'-') expr #ExprUnitario 
    | expr op=('*'|'/'|'%') expr #ExprMultDivMod
    | expr op=('+'|'-') expr #ExprAddSub
    | Integer #ExprInteger
    | '(' expr ')' #ExprParent
    | ID     #ExprID ;
ID : [a-zA-Z]+;
Integer : [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;