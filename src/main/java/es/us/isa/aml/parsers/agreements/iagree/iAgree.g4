grammar iAgree;


/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : template END_TEMPLATE
      | agOffer END_AG_OFFER
      ;
 
template : TEMPLATE id=Identifier VERSION version=versionNumber template_def ;

agOffer : AG_OFFER id=Identifier VERSION version=versionNumber FOR (TEMPLATE)? templateId=Identifier VERSION templateVersion=versionNumber ag_def;

template_def : temp_properties* agreementTerms creationConstraints?;

ag_def : temp_properties*  agreementTerms;

temp_properties : initiator_prop
                | responder_prop 
                | serviceProvider_prop 
                | expirationTime_prop
                | dateFormat_prop
                | gmtZone_prop
                | globalPeriod_prop
                | definedPeriod_prop
                | metrics_prop
                ;

agreementTerms : AGREEMENT_TERMS service monitorableProperties guaranteeTerms;

creationConstraints : CREATION_CONSTRAINTS creationConstraint+;

creationConstraint : (Identifier) ':' expression ';' qualifyingCondition?;

//---------------------------------------
// Template properties
//---------------------------------------

initiator_prop : INITIATOR ':' String;

responder_prop : (PROVIDER | CONSUMER | Identifier) AS RESPONDER;

serviceProvider_prop : SERVICEPROVIDER ':' String;
				
expirationTime_prop : EXPIRATIONTIME ':' String;

dateFormat_prop : DATEFORMAT ':' String;

gmtZone_prop : GMTZONE ':' (S_Integer | Integer);

globalPeriod_prop : GLOBALPERIOD ':' datePeriod_def;

definedPeriod_prop : DEFINEDPERIOD ':' period+;

metrics_prop : METRICS ':' (metric)+;

metric: id=Identifier ':' (type=SET list | type=ENUM list | type=(INTEGER | FLOAT | NATURAL | NUMBER | BOOLEAN) (range)? (list)?) ; 


//---------------------------------------
// Temp. definitions
//---------------------------------------

datePeriod_def : DURING Date '..' Date;

temporality : ON Identifier;

period : Identifier ':' period_def ((EXCEPT|AND) period_def)*;

period_def : FROM Hour '..' Hour (ON Identifier)? datePeriod_def 
           | Identifier
           | GLOBALPERIOD
           ;


//---------------------------------------
// Agreement Terms definitions
//---------------------------------------
			
service : SERVICE Identifier (AVAL_AT url)? 
          (features)? 
          globalDescription 
          localDescription*
        ;

features : FEATURES ':' feature*;
feature : feature_operation (',' feature_operation)*;
feature_operation : id=Identifier ('(' Identifier (',' Identifier )* ')')?;

globalDescription : GLOBALDESCRIPTION
                    (property)+
                  ;

localDescription : DESCRIPTION FOR Identifier ':' (property)+;
		
monitorableProperties : MONITORABLEPROPERTIES (Identifier)? 
                        global_MonitorableProperties? 
                        local_MonitorableProperties*
                      ;
				
global_MonitorableProperties : GLOBAL ':' 
                               (property)*
                             ;
				
local_MonitorableProperties : FOR Identifier ':' (property)+;
				
guaranteeTerms : GUARANTEE_TERMS 
                 (guaranteeTerm)*
               ;
				
guaranteeTerm : Identifier ':' (guarantee_def | cuantif OF (guaranteeTerm)+) (END)?;
							
guarantee_def : ob=(PROVIDER | CONSUMER) GUARANTEES slo temporality? ';' 
                (serviceScope)?
                (qualifyingCondition)?
                (compensations)*
              ;

slo : expression;

serviceScope : UPON Identifier ';';
	
qualifyingCondition : ONLY_IF '(' expression ')' ';';

compensations : WITH interv=compensationsInterval  compType=(PENALTY | REWARD)
                (compensation)+
                END;

compensationsInterval : YEARLY
         | MONTHLY
         | WEEKLY
         | DAILY
         | HOURLY
         | MINUTELY
         ;

compensation : OF e1=expression IF e2=expression ';';



//----------------------------------
// CORE ELEMENTS
//----------------------------------

versionNumber : Float
              | Version
              ;

url : Url
    | String
    ;

property : id=(Identifier | Access) ':' met=(Identifier | BOOLEAN) (ASSIG value=expression ';')? ;


expression: Identifier ASSIG expression                     #assigExpr
          | NOT expression                                  #notExpr
          | expression op=(MULTIPLY | DIVIDE) expression    #multiplicationExpr
          | expression op=(ADD | SUBTRACT) expression       #additiveExpr
          | expression op=(LTE | GTE | LT | GT) expression  #relationalExpr
          | expression op=(EQ | NEQ) expression             #equalityExpr
          | expression AND expression                       #andExpr
          | expression OR expression                        #orExpr
          | PA expression PC                                #parExpr
          | atom                                            #atomExpr
          ;

atom
 : (Integer | S_Integer | Float | S_Float)  #numberAtom
 | (TRUE | FALSE)                           #booleanAtom
 | Identifier                               #idAtom
 | String                                   #stringAtom
 ;

cuantif : EXACTLY_ONE 
        | ONE_OR_MORE
        | ALL
        ;

list : '{' l1=listArg (',' l2=listArg)* '}' ;

listArg : l1=(Identifier | String | Integer | S_Integer | Float | S_Float);

range : '[' min=(Integer | S_Integer) '..' max=(Integer | S_Integer) ']' ;


/*=====================================
            LEXICAL RULES
 ======================================*/

//---------------------------------------
// Language Keywords
//---------------------------------------

TEMPLATE : 'Template';
END_TEMPLATE : 'EndTemplate';

AG_OFFER : 'AgreementOffer';
END_AG_OFFER : 'EndAgreementOffer';

INITIATOR : 'Initiator';
RESPONDER : 'Responder';
SERVICEPROVIDER : 'ServiceProvider';
EXPIRATIONTIME : 'ExpirationTime';
DATEFORMAT : 'DateFormat';
GMTZONE : 'GMTZone';
GLOBALPERIOD : 'GlobalPeriod';
DEFINEDPERIOD : 'DefinedPeriod';
METRICS : 'Metrics';

AGREEMENT_TERMS : 'AgreementTerms';
CREATION_CONSTRAINTS : 'CreationConstraints';
GUARANTEE_TERMS : 'GuaranteeTerms';

SERVICE : 'Service';
FEATURES: 'Features';
GLOBALDESCRIPTION : 'GlobalDescription';
DESCRIPTION : 'Description';
GLOBAL : 'global';
MONITORABLEPROPERTIES : 'MonitorableProperties';
GUARANTEES : 'guarantees';

AVAL_AT : 'availableAt.';

PROVIDER : 'Provider';
CONSUMER : 'Consumer';

VERSION : 'version';

EXCEPT : 'except';
DURING : 'during';

BOOLEAN : 'boolean';
INTEGER : 'integer';
FLOAT : 'float';
NATURAL : 'natural';
NUMBER : 'number';
SET : 'set';
ENUM : 'enum';

TRUE : 'true';
FALSE : 'false';

WITH : 'with';
END : 'end';
IF : 'if';

YEARLY : 'yearly';
MONTHLY : 'monthly';
WEEKLY : 'weekly';
DAILY : 'daily';
HOURLY : 'hourly';
MINUTELY : 'minutely';

PENALTY : 'penalty';
REWARD : 'reward';

ON : 'on';
FROM : 'from';
OF : 'of';
FOR : 'for';
AS : 'as';


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
// Logical connective
//---------------------------------------

AND : 'AND';
OR : 'OR';
NOT : 'NOT';
IMPLIES : 'IMPLIES';
ONLY_IF : 'onlyIf';


//---------------------------------------
// Quantity
//---------------------------------------

EXACTLY_ONE : 'exactly one';
ONE_OR_MORE : 'one or more';
ALL : 'all';


//---------------------------------------
// Logical operators
//---------------------------------------

LT : '<';
GT : '>';
EQ : '==';
NEQ : '!=';
LTE : '<=';
GTE : '>=';

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

Url : ('http'|'https'|'ftp'|'file')':''/''/'[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
    ;

Version : Integer ('.' Integer)+;
Date : Integer [-/] Integer [-/] Integer;
Hour : Digit? Digit ':' Digit Digit;
Access : Identifier ('.' Identifier)+;
Unit : '%' | 'min';
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