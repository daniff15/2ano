grammar CalcFracional;

program: print* EOF | assignment;

print: ('print'+ expr)? NEWLINE;
assignment: expr '->' ID;
expr:
	op = ('+' | '-') expr				# ExprUnitario
	| expr op = ('*' | ':' | '%') expr	# ExprMultDivMod
	| expr op = ('+' | '-') expr		# ExprAddSub
	| Integer							# ExprInteger
	| Integer '/' Integer				# ExprFraction
	| '(' expr ')'						# ExprParent
	| ID								# ExprID;

ID: [a-zA-Z]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;

//FAZER AS CENAS DO UNARIO; POTENCIAS; REDUCE