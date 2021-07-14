grammar FracLang;

program : (stat';')* EOF;

stat: display | assign;

expr: 
     op=('+'|'-') expr          #Unario
    | expr op=(':'|'*') expr    #MultiDiv
    | expr op=('+'|'-') expr    #AddSub
    | '(' expr ')'              #Parent
    | expr'/'expr               #Fraction   
    | INTEGER                   #Integer
    | ID                        #Identifier
    ;

display: 'display' expr;
assign: ID '<=' expr;

ID : [a-z]+;
INTEGER: [0-9]+;
COMMENT : '--' .*? '\n' -> skip;
WS : [ \t\r\n]+ -> skip;
