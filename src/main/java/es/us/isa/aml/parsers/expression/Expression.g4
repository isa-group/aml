grammar Expression;

parse : expression
      ;

expression: Identifier ASSIG expression                     #assigExpr
          | PA expression PC                                #parExpr
          | NOT expression                                  #notExpr
          | expression op=(MULTIPLY | DIVIDE) expression    #multiplicationExpr
          | expression op=(ADD | SUBTRACT) expression       #additiveExpr
          | expression op=(LTE | GTE | LT | GT) expression  #relationalExpr
          | expression op=(EQ | NEQ) expression             #equalityExpr
          | expression AND expression                       #andExpr
          | expression OR expression                        #orExpr
          | expression (IMPLIES | REQUIRES) expression      #impliesExpr
          | expression IFF expression                       #iffExpr
          | expression EXCLUDES expression                  #excludesExpr
          | list                                            #listExpr
          | array                                           #arrayExpr
          | atom                                            #atomExpr
          ;

list : CA l1=args (',' l2=args)* CC ;
array : LLA l1=args (',' l2=args)* LLC ;
args : l1=(Identifier | String | Integer | S_Integer | Float | S_Float);

atom : (Integer | S_Integer | Float | S_Float)   #numberAtom
       | (TRUE | FALSE)                          #booleanAtom
       | id=Identifier CA value=String CC        #arrayAtom
       | Identifier                              #idAtom
       | String                                  #stringAtom
     ;


BOOLEAN : 'boolean';
INTEGER : 'integer';
FLOAT : 'float';
NATURAL : 'natural';
NUMBER : 'number';
SET : 'set';
ENUM : 'enum';

TRUE : 'true';
FALSE : 'false';

//---------------------------------------
// Commons tokens
//---------------------------------------

CA : '[';
CC : ']';
PA : '(';
PC : ')';
LLA : '{';
LLC : '}';


//---------------------------------------
// Logical operators
//---------------------------------------

AND : 'AND';
OR : 'OR';
NOT : 'NOT';
IMPLIES : 'IMPLIES';
REQUIRES : 'REQUIRES';
IFF: 'IFF';
EXCLUDES : 'EXCLUDES';


//---------------------------------------
// Arithmetical operators
//---------------------------------------

ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';

//---------------------------------------
// Relational tokens
//---------------------------------------

LT : '<';
GT : '>';
EQ : '==';
NEQ : '!=';
LTE : '<=';
GTE : '>=';
ASSIG: '=';
BELONGS : 'belongs';
UPON : 'upon';

//---------------------------------------
// Basic Lexical Elements
//---------------------------------------

Identifier: Letter ('-'|'_'|'.'|LetterOrDigit)*;

fragment Letter : [a-zA-Z$_];

fragment LetterOrDigit : [a-zA-Z0-9$_];

// Literals

Integer : Digit+;
S_Integer : [+-] Integer;

Float: Integer '.' Integer;
S_Float : [+-] Float;

Boolean : 'true' | 'false';

fragment Digit : '0' | NonZeroDigit;
fragment NonZeroDigit : [1-9];
String : '\'' ~[']* '\'' 
       | '"' ~["]* '"'
       ;

//---------------------------------------
// Padding & Comments
//---------------------------------------

WS : [ \t\r\n]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;


