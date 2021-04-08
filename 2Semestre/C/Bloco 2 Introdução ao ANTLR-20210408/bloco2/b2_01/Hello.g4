grammar Hello;             //Define grammar called Hello
option : greetings | bye;
greetings : 'Hello' ID ;    //match keyword hello forward by an identifier
bye : 'Bye' ID ;
ID : [a-z]+ ;               // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ;   // skip spaces,tabs,newlines, \r(windows)