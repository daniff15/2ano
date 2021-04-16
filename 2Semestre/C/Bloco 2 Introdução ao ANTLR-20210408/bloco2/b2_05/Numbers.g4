grammar Numbers ;
file : line* EOF ;
line : Number '-' Word;
Number : [0-9]+;
Word : [a-zA-Z]+;

NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip; 