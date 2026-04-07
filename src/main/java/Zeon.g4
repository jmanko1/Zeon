grammar Zeon;

program	: (func | stat)* EOF ;

block: stat* ;

stat    : decl SEMIC	        # DeclStat
        | assign SEMIC		    # AssignStat
        | print SEMIC		    # PrintStat
        | read SEMIC		    # ReadStat
        | expr SEMIC		    # ExprStat
        | blockifelse		    # IfElseStat
        | blockwhile		    # WhileStat
        | RETURN expr SEMIC	    # ReturnStat
        ;

func    : functype ID LPAREN params? RPAREN LBRACE block RBRACE ;

params  :   param (COMMA param)* ;

param   : type ID ;

functype    : type | VOID ;

blockifelse     : blockif blockelse?;

blockif     : IF LPAREN cond RPAREN LBRACE block RBRACE ;

blockelse   : ELSE LBRACE block RBRACE ;

blockwhile  : WHILE LPAREN cond RPAREN LBRACE block RBRACE ;

cond        : orCond ;
orCond      : andCond (OR andCond)* ;
andCond     : atomCond (AND atomCond)* ;
atomCond    : expr op=(EQ|NEQ|GT|LT|GTE|LTE) expr
            | LPAREN cond RPAREN
            | expr
            ;

decl	: type ID ;

assign	: (type)? ID ASSIGN expr ;

print	: PRINT LPAREN expr RPAREN ;
read	: (type)? ID ASSIGN READ LPAREN RPAREN ;

type	: INTTYPE | FLOATTYPE | LONGINT | DOUBLE | BOOLTYPE;

expr    : LPAREN expr RPAREN		        # Parens
        | ID LPAREN args? RPAREN          # CallFunc
        | SUB expr                      # UnaryMinus
        | expr op=(MULT | DIV) expr	    # MultDiv
        | expr op=(ADD | SUB) expr	    # AddSub
        | REAL				            # Real
        | INT				            # Int
        | ID				            # Id
        | TRUE  #TrueLit
        | FALSE #FalseLit
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

AND : '&&' ;
OR  : '||' ;
BOOLTYPE : 'bool' ;
TRUE     : 'true' ;
FALSE    : 'false' ;

REAL	: [0-9]+ '.' [0-9]+ ;
INT	    : [0-9]+ ;
ID      : [a-z]([a-z0-9_]*[a-z0-9])? ;
SEMIC	: ';' ;
COMMA   : ',' ;
ASSIGN	: '=' ;
LPAREN	: '(' ;
RPAREN	: ')' ;
LBRACE	: '{' ;
RBRACE	: '}' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
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