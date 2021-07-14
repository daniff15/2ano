grammar StrLang;

program : stat* EOF;

stat: print 
    | assign;

print: ('print' expr)  #printText;
input : 'input' '(' TEXT ')'; 
assign: ID ':'  ( expr | input );

expr: TEXT                      #visitText
    | ID                        #ID
    | expr op='+' expr          #visitAdd
    | expr op='-' expr          #visitSub
    | 'trim' expr               #visitTrim
    | expr '/' expr '/' expr    #visitSubstitution;

ID : [A-Za-z0-9]+;
TEXT : '"' .*? '"';
NEWLINE: '\r'? '\n';
COMMENT : '//' .*? '\n' -> skip;
WS : [ \t\r\n]+ -> skip;