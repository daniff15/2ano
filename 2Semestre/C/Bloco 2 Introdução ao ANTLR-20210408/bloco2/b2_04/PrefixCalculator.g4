grammar PrefixCalculator;
program : stat* EOF;
stat : expr? NEWLINE;
expr:  op=('*'|'/'|'+'|'-') expr expr #operators
    | Number                        #Numbers;

Number: [0-9]+('.'[0-9]+);
NEWLINE: '\r'? '\n';
WSS : [ \t]+ -> skip;