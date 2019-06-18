lexer grammar Lexemes;

PROGRAM: '_program';
CLASS: '_class';
METHOD: '_method';
ATTR: '_attr';
FORMAL: '_formal';
BRANCH: '_branch';
ASSIGN: '_assign';
STATIC_DISPATCH: '_static_dispatch';
DISPATCH: '_dispatch';
COND: '_cond';
LOOP: '_loop';
TYPCASE: '_typcase';
BLOCK: '_block';
LET: '_let';
PLUS: '_plus';
SUB: '_sub';
MUL: '_mul';
DIVIDE: '_divide';
NEG: '_neg';
LT: '_lt';
EQ: '_eq';
LEQ: '_leq';
COMP: '_comp';
INT: '_int';
STR: '_string';
BOOL: '_bool';
NEW: '_new';
ISVOID: '_isvoid';
NO_EXPR: '_no_expr';
NO_TYPE: '_no_type';
BOTTOM: '_bottom';
OBJECT: '_object';
THROW: '_throw';
TRY_CATCH: '_try_catch';
TRY_FINALLY: '_try_finally';


ID:  [A-Za-z][_A-Za-z0-9]*;
INT_CONST: [0-9][0-9]*;

LINENO: '#'[0-9]*;

LPAREN: '(';
RPAREN: ')';
COLON: ':';

STR_CONST:   '"' ( ESC | .)*? '"';
// To do: deal with octal etc.

WS:  [ \t\b\f\r\n]+ -> skip;

fragment
ESC: '\\"' | '\\\\' ;  // book, pg 78


