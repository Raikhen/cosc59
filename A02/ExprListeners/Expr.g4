grammar Expr;

line    : expr ';' EOF;

expr    : term terms;

terms   : '+' term terms
        | '-' term terms
        |
        ;

term    : factor factors;

factors : '*' factor factors
        | '/' factor factors
        | MOD factor factors
        |
        ;

factor  : '(' expr ')'
        | ID
        | NUM
        ;

MOD : 'MOD';
NUM : [0-9]+;
ID  : [a-zA-Z] ([a-zA-Z] | [0-9])*;

// Ignore all whitespace
WS  : (' ' | '\t' | '\n' | '\r') -> skip;