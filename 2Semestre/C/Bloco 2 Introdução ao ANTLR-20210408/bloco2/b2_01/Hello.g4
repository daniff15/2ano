grammar Hello;             //Define grammar called Hello

main: option*  EOF; 
option : (greetings | bye)+;
//Sem os parenteses e o + a frente, aparecem logo as mensagens presentes no visitor
//Assim so aparecem quando se terminar o programa
//Se nao tivesse quando se acabasse so aparecia a primeria mensagem
//Nao pode ser criado, para isto acontecer com a opcao -i
greetings : 'Hello' ID+ ;    //match keyword hello forward by an identifier
bye : 'Bye' ID+ ;
ID : [a-zA-Z]+ ;               // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ;   // skip spaces,tabs,newlines, \r(windows)