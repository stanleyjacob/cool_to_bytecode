grammar Cool;
import Lex;

program
   : (klass SEMI)+ EOF
   ;

klass
   : CLASS TYPE (INHERITS TYPE)? LBRACE (feature SEMI)* RBRACE { System.out.println("Class ended: " + CoolLexer.linenum); }
   ;

feature
   : ID LPAREN (formal (COMMA formal)*)* RPAREN COLON TYPE LBRACE expr RBRACE # method
   | <assoc=right> ID COLON TYPE (ASSIGN expr)? # attr
   ;

formal
  : ID COLON TYPE
  ;

let_formal
  : <assoc=right> ID COLON TYPE (ASSIGN expr)?
;

expr
   : ID LPAREN (expr (COMMA expr)*)* RPAREN # selfdispatch
   | expr (AT TYPE)? PERIOD ID LPAREN (expr (COMMA expr)*)* RPAREN # dispatch
   | IF expr THEN expr ELSE expr FI # if
   | WHILE expr LOOP expr POOL # while
   | LET let_formal (COMMA let_formal)* IN expr # let
   | CASE expr OF (ID COLON TYPE DARROW expr SEMI)+ ESAC # case
   | NEW TYPE # new
   | NEG expr # neg
   | ISVOID expr # isvoid
   | LPAREN expr RPAREN # paren
   | LBRACE (expr SEMI)+ RBRACE # block
   | expr MUL expr # mul
   | expr DIV expr # div
   | expr ADD expr # add
   | expr MINUS expr # minus
   | expr LEQ expr # lessThanOrEqualTo
   | expr LT expr # lessThan
   | expr EQ expr # eq
   | NOT expr # not
   | <assoc=right> ID ASSIGN expr # assign
   | ID # id
   | INT_CONST # int_const
   | STR_CONST # str_const
   | TRUE # bool_true
   | FALSE # bool_false
   ;
