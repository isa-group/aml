grammar iAgree;


/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : template END_TEMPLATE
      | agOffer END_AG_OFFER
      ;
 
template : TEMPLATE Identifier VERSION versionNumber template_def
         ;

agOffer : AG_OFFER Identifier VERSION versionNumber FOR (TEMPLATE)? Identifier VERSION versionNumber ag_def;

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

agreementTerms : AGREEMENT_TERMS agreementTerms_def;

creationConstraints : CREATION_CONSTRAINTS creationConstraints_def;

agreementTerms_def : service monitorableProperties guaranteeTerms;

creationConstraints_def	: creationConstraint+;

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

metrics_prop : METRICS ':' (key_value_prop)+;

//---------------------------------------
// Temp. definitions
//---------------------------------------

datePeriod_def : DURING Date '..' Date;

temporality : ON Identifier;

period : Identifier ':' period_def ((EXCEPT|AND) period_def)*;

period_def : FROM Hour '..' Hour (ON Identifier)? datePeriod_def 
           | id
           | GLOBALPERIOD
           ;


//---------------------------------------
// Agreement Terms definitions
//---------------------------------------
			
service : SERVICE Identifier (AVAL_AT url)? (features)? 
          globalDescription descriptions
        ;

features : FEATURES ':' feature (',' feature)*;

globalDescription : GLOBALDESCRIPTION (key_value_prop)+;

descriptions : description*;
				
feature : op (',' op)*;

description : DESCRIPTION FOR feature (',' feature)* key_value_prop+;
		
monitorableProperties : MONITORABLEPROPERTIES (Identifier)? 
                        global_MonitorableProperties? 
                        local_MonitorableProperties*
                      ;
				
global_MonitorableProperties : GLOBAL ':' (key_value_prop)*;
				
local_MonitorableProperties : FOR Identifier ':' key_value_prop+;
				
guaranteeTerms : GUARANTEE_TERMS (guaranteeTerm)*;
				
guaranteeTerm : Identifier ':' 
                (guarantee_def | cuantif OF grouped_guaranteeTerm) (END)?
              ;

grouped_guaranteeTerm : (guaranteeTerm)+;
							
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

id : Identifier;

versionNumber : Float
              | Version
              ;

url : Url
    | String
    ;

key_value_prop : k=(Identifier | Access | BOOLEAN | INTEGER ) ':' 
                 (v=String | v2=type)  (EQ a=assig_value ';')?
               ;

assig_value : val=(Identifier | Integer | String)+ (operation)?
            | (TRUE | FALSE)
            | Float (Unit)? (operation)?
            | S_Float (Unit)? (operation)?
            | S_Integer (Unit)? (operation)?
            | list
            ;

operation : Operador assig_value;

expression : NOT e1=expression
           | '(' e1=expression ')'
             (log=(AND|OR|IMPLIES) e2=expression)?
           | ident=(Identifier | Access | String) (cmp=(EQ|LT|GT|LTE|GTE) val=assig_value)? (log=(AND|OR|IMPLIES) e1=expression)?
           | ident=(Identifier | Access) BELONGS l=list (log=(AND|OR|IMPLIES) e1=expression)?
           ;

op : Identifier ('(' Identifier (',' Identifier )* ')')?;

cuantif : EXACTLY_ONE 
        | ONE_OR_MORE
        | ALL
        ;

type : Identifier 
     | SET list 
     | ENUM list 
     | v=(INTEGER | FLOAT | NATURAL | NUMBER | BOOLEAN) (range)? 
     ;

list : '{' l1=listArg (',' l2=listArg)* '}'
     ;

listArg : l1=(Identifier | String | Integer | S_Integer | Float | S_Float);

range : '[' min=(Integer | S_Integer) '..' max=(Integer | S_Integer) ']'
      ;


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
FEATURES: 'Features/Operations';
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
// Relational tokens
//---------------------------------------

LT : '<';
GT : '>';
EQ : '=';
LTE : '<=';
GTE : '>=';
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
Operador : '+'|'-'|'*'|'/';
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