grammar SuffixCalculator;
program : stat* EOF;
stat : expr? NEWLINE;
expr: expr expr op=('*'|'/'|'+'|'-') #operators
    | Number                        #Numbers;

Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WSS : [ \t]+ -> skip;