grammar BigIntCalc;

program: (stat ';')*EOF;

stat: show | assign;

show: 'show' expr;

assign: expr '->' ID;

expr:
    op=('+' | '-') expr #exprUnario
    | expr op=( 'div'|'*'|'mod') expr #exprMultiDivMod
    | expr op=('+'|'-') expr #exprSumSub
    | '(' expr ')' #exprParent
    | INTEGER         #exprInt
    | ID            #exprID
    ;

INTEGER: [0-9]+;
ID: [a-zA-Z]([a-zA-Z0-9]+)*;
WS : [ \t\r\n]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
ERROR: . ;
