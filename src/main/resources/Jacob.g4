grammar Jacob;

program	: (func | stat)+ EOF ;

block: stat+ ;

stat	: decl SEMIC		# DeclStat
	| assign SEMIC		# AssignStat
	| print SEMIC		# PrintStat
	| read SEMIC		# ReadStat
	| expr SEMIC		# ExprStat
	| blockif		# IfStat
	| blockwhile		# WhileStat
	| RETURN expr SEMIC	# ReturnStat
	;

func	: type ID LBRAC type ID RBRAC LCLASP block RCLASP ;

blockif	: IF LBRAC cond RBRAC LCLASP block RCLASP ;

blockwhile : WHILE LBRAC cond RBRAC LCLASP block RCLASP ;

cond	: expr (EQ | NEQ | GT | LT | GTE | LTE) expr ;

decl	: type ID ;

assign	: (type)? ID ASSIGN expr ;

type	: INTTYPE | REALTYPE | LONGINT | LONGREAL ;

print	: PRINT LBRAC expr RBRAC ;
read	: ID ASSIGN READ LBRAC RBRAC ;

expr	: LBRAC expr RBRAC		# Parens
	| expr op=(MULT | DIV) expr	# MultDiv
	| expr op=(ADD | SUB) expr	# AddSub
	| ID LBRAC expr RBRAC		# CallFunc
	| REAL				# Real
	| INT				# Int
	| ID				# Id
	;


READ	: 'read' ;
PRINT	: 'print' ;
INTTYPE	: 'int' ;
REALTYPE: 'real' ;
LONGREAL: 'lreal';
LONGINT	: 'lint' ;
IF	: 'if' ;
WHILE	: 'while' ;
RETURN	: 'return' ;

REAL	: [0-9]+ '.' [0-9]+ ;
INT	: [0-9]+ ;
ID	: [a-zA-Z]+ ;

SEMIC	: ';' ;
ASSIGN	: '=' ;
LBRAC	: '(' ;
RBRAC	: ')' ;
LCLASP	: '{' ;
RCLASP	: '}' ;
ADD	: '+' ;
SUB	: '-' ;
MULT	: '*' ;
DIV	: '/' ;
EQ	: '==' ;
NEQ	: '!=' ;
GT	: '>' ;
LT	: '<' ;
GTE	: '>=' ;
LTE	: '<=' ;

WS	: [ \t\r\n]+ -> skip ;