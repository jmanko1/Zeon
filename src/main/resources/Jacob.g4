grammar Jacob;

program	: (func | stat)* EOF ;

block: stat+ ;

stat    : decl SEMIC	        # DeclStat
        | assign SEMIC		    # AssignStat
        | print SEMIC		    # PrintStat
        | read SEMIC		    # ReadStat
        | expr SEMIC		    # ExprStat
        | blockif		        # IfStat
        | blockwhile		    # WhileStat
        | RETURN expr SEMIC	    # ReturnStat
        ;

func    : functype ID LBRAC params? RBRAC LCLASP block RCLASP ;

params  :   param (COMMA param)* ;

param   : type ID ;

functype    : type | VOID ;

blockif     : IF LBRAC cond RBRAC LCLASP block RCLASP ;

blockwhile  : WHILE LBRAC cond RBRAC LCLASP block RCLASP ;

cond	: expr op=(EQ | NEQ | GT | LT | GTE | LTE) expr ;

decl	: type ID ;

assign	: (type)? ID ASSIGN expr ;

print	: PRINT LBRAC expr RBRAC ;
read	: (type)? ID ASSIGN READ LBRAC RBRAC ;

type	: INTTYPE | FLOATTYPE | LONGINT | DOUBLE ;

expr    : LBRAC expr RBRAC		        # Parens
        | ID LBRAC args? RBRAC          # CallFunc
        | SUB expr                      # UnaryMinus
        | expr op=(MULT | DIV) expr	    # MultDiv
        | expr op=(ADD | SUB) expr	    # AddSub
        | REAL				            # Float
        | INT				            # Int
        | ID				            # Id
        ;

args    : expr (COMMA expr)* ;

READ	    : 'read' ;
PRINT	    : 'print' ;
LONGINT	    : 'long int' ;
INTTYPE	    : 'int' ;
FLOATTYPE   : 'float' ;
DOUBLE      : 'double';
VOID        : 'void' ;
IF	        : 'if' ;
ELSE        : 'else' ;
WHILE	    : 'while' ;
RETURN	    : 'return' ;

REAL	: [0-9]+ '.' [0-9]+ ;
INT	    : [0-9]+ ;
ID      : [a-z][a-z0-9]* ;
SEMIC	: ';' ;
COMMA   : ',' ;
ASSIGN	: '=' ;
LBRAC	: '(' ;
RBRAC	: ')' ;
LCLASP	: '{' ;
RCLASP	: '}' ;
LSQBRAC : '[' ;
RSQBRAC : ']' ;
ADD	    : '+' ;
SUB     : '-' ;
MULT    : '*' ;
DIV	    : '/' ;
EQ	    : '==' ;
NEQ	    : '!=' ;
GT	    : '>' ;
LT	    : '<' ;
GTE 	: '>=' ;
LTE	    : '<=' ;

COMMENT : '#' ~[\r\n]* -> skip ;
WS	    : [ \t\r\n]+ -> skip ;