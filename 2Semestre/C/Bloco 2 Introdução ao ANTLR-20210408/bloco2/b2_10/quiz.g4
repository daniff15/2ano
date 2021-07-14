grammar quiz;

program: print* EOF;

print: ID + '(' + QUESTION + ')' + '{' RESPS* '}' ;

ID: [a-zA-Z.0-9]+;
QUESTION: [a-zA-Z]+;
STRING : '"' .*? '"';
RESPS : '"' + STRING + '"' + ':' + Integer + ';';
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t\r\n]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;