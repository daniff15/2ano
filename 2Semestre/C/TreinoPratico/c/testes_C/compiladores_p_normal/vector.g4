grammar vector;

program : stat* EOF;

stat : (show
    | assign)? ';';

show: 'show' expr;

assign: expr '->' ID;

expr: 
     op=('+' | '-') expr        #unario
    | expr op=('+'|'-') expr    #somaSub
    | expr '.' expr             #internProduct
    | expr '*' expr             #multi
    | '(' expr ')'              #parent 
    | '[' expr (',' expr)* ']'  #vector
    | ID                        #id 
    | NUMBER                    #number
    ; 

NUMBER : [0-9]+ ('.'[0-9]+)?;
ID: [a-z]([a-z0-9]+)*;
COMMENT : '//' .*? '\n' -> skip;
WS : [ \t\r\n]+ -> skip;