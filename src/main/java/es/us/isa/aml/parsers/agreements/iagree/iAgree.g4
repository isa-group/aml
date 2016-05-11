grammar iAgree;

/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : template END_TEMPLATE
      | agOffer END_AG_OFFER
      | agreement END_AGREEMENT
      ;
 
template : TEMPLATE id=Identifier VERSION version=versionNumber template_def;

agOffer : AG_OFFER id=Identifier VERSION version=versionNumber FOR (TEMPLATE)? templateId=Identifier VERSION templateVersion=versionNumber ag_def;

agreement : AGREEMENT id=Identifier VERSION version=versionNumber ag_def;

template_def : temp_properties* agreementTerms creationConstraints?;

ag_def : temp_properties*  agreementTerms;

temp_properties : context_prop
                | partiesRoles_prop
                | metrics_prop
                ;

agreementTerms : AGREEMENT_TERMS service monitorableProperties? guaranteeTerms?;

creationConstraints : CREATION_CONSTRAINTS creationConstraint+;

creationConstraint : (Identifier) ':' expression ';' qualifyingCondition?;

//---------------------------------------
// Template properties
//---------------------------------------

context_prop : CREATED FROM id=(Identifier | String) (AVAL_AT url)? ';' ;

partiesRoles_prop : role=PROVIDER id=(Identifier | String) AS roleType=(INITIATOR | RESPONDER) ';'
                  | role=CONSUMER id=(Identifier | String) AS roleType=(INITIATOR | RESPONDER) ';'
                  ;

metrics_prop : METRICS ':' (metric)+;

metric: id=Identifier ':' (type=SET (list|array) | type=ENUM (list|array) | type=(INTEGER | FLOAT | NATURAL | NUMBER | BOOLEAN) (range)? (list)?) ';' ; 

//---------------------------------------
// Agreement Terms definitions
//---------------------------------------
			
service : SERVICE Identifier (AVAL_AT endpointUrl=url)?
          (features)? 
          globalDescription 
          localDescription*
        ;

features : FEATURES ':' feature*;
feature : feature_operation (',' feature_operation)* ';';
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

property : id=(Identifier | Access) ':' met=(Identifier | BOOLEAN | RESOURCE | STRING)
           (DEFINED_AT definitionUrl=url)?
           (ASSIG value=expression)? 
            ';';
				
guaranteeTerms : GUARANTEE_TERMS 
                 (guaranteeTerm)*
               ;
				
guaranteeTerm : Identifier ':' guarantee_def;
							
guarantee_def : ob=(PROVIDER | CONSUMER) GUARANTEES slo ';' 
                (serviceScope)?
                (qualifyingCondition)?
                (compensation)*
              ;

slo : expression;

serviceScope : UPON Identifier ';';
	
qualifyingCondition : ONLY_IF '(' expression ')' ';';

compensation :  WITH interv=compensationsInterval  compType=(PENALTY | REWARD)
                compensationElement+
                compensationLimit*
                END;

compensationElement : OF exp=expression IF cond=expression ';';
compensationLimit : UPTO exp=expression ';';

compensationsInterval : YEARLY
         | MONTHLY
         | WEEKLY
         | DAILY
         | HOURLY
         | MINUTELY
         | SECONDLY
         ;

duringInterval : YEAR
               | MONTH
               | WEEK
               | DAY
               | HOUR
               | MINUTE
               | SECOND
               ;


//----------------------------------
// CORE ELEMENTS
//----------------------------------

versionNumber : Float
              | Version
              ;

url : Url
    | String
    ;

cuantif : EXACTLY_ONE 
        | ONE_OR_MORE
        | ALL
        ;

range : '[' min=(Integer | S_Integer) '..' max=(Integer | S_Integer) ']' ;


/*=====================================
              EXPRESSION
 ======================================*/


expression: Identifier ASSIG expression                     #assigExpr
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
          | expression IN state=expression 
            op=BY dur=expression durInt=duringInterval      #duringExpr
          | expression IN state=expression 
            op=(LTE | GTE | LT | GT | EQ) ntimes=expression 
            compInt=compensationsInterval                   #freqExpr
          | PA expression PC                                #parExpr
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

AGREEMENT : 'Agreement';
END_AGREEMENT : 'EndAgreement';

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

AVAL_AT : 'availableAt';
DEFINED_AT : 'definedAt';
MONITORED_AT : 'monitoredAt';

PROVIDER : 'Provider';
CONSUMER : 'Consumer';

VERSION : 'version';

EXCEPT : 'except';
DURING : 'during';

STRING : 'string';
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

ONLY_IF : 'onlyIf';

YEARLY : 'yearly';
MONTHLY : 'monthly';
WEEKLY : 'weekly';
DAILY : 'daily';
HOURLY : 'hourly';
MINUTELY : 'minutely';
SECONDLY : 'secondly';

YEAR : 'year' | 'years';
MONTH : 'month' | 'months';
WEEK : 'week' | 'weeks';
DAY : 'day' | 'days';
HOUR : 'hour' | 'hours';
MINUTE : 'minute' | 'minutes';
SECOND : 'second' | 'seconds';

PENALTY : 'penalty';
REWARD : 'reward';

CREATED : 'Created';
ON : 'on';
FROM : 'from';
OF : 'of';
FOR : 'for';
AS : 'as';
UPTO : 'upTo';

IN : 'in';
BY : 'by';
RESOURCE : 'resource';

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
// Quantity
//---------------------------------------

EXACTLY_ONE : 'exactly one';
ONE_OR_MORE : 'one or more';
ALL : 'all';


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

Url : ('http'|'https'|'ftp'|'file')':''/''/'[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
    ;

Version : Integer ('.' Integer)+;
Date : Integer [-/] Integer [-/] Integer;
Hour : Digit? Digit ':' Digit Digit (':' Digit Digit)?;
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