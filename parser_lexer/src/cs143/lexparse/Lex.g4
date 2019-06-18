lexer grammar Lex;

@lexer::members {
  public static int linenum = 0;
  public static boolean inComment = false;
  public static boolean inString = false;
  public static boolean initial = true;
  public static int nesting = 0;
}


NEWLINE: '\r'? '\n' { linenum++; System.out.println("Line :" + linenum); } -> skip;
WS:  [ \t\f\r\n]+ -> skip;

LINECOMMENT: '--' (~ '\n')* '\n' { linenum++; System.out.println("Line :" + linenum); } -> skip;
LINECOMMENTEOF: '--' (~ '\n')* EOF { System.out.println("Line :" + linenum); } -> skip;

BEGINCOMMENT: '(*' {initial}? { inComment = true; initial = false; nesting++; System.out.println("start comment");} -> skip ;

// About the nestable comments

BEGINCOMMENTNEST: '(*' {inComment}? { nesting++; } -> skip;
ENDCOMMENT:  '*)' {inComment}?
      { nesting--;
        if (nesting == 0) {
          inComment = false; initial = true; System.out.println("end comment");
        }
      } -> skip;
IGNOREINCOMMENT: ~[*(\n]+  {inComment}?  { System.out.println("Discarding chars:" + getText()); } -> skip;
IGNOREINCOMMENTLPAREN : '(' { inComment}?  { System.out.println("Discarding lparen"); }  -> skip;
IGNOREINCOMMENTSTAR : '*' { inComment}?  { System.out.println("Discarding star"); }  -> skip;
IGNOREINCOMMENTNEWLINE: '\n' {inComment}?  { linenum++; System.out.println("Line :" + linenum); } -> skip;

BADENDCOMMENT:  '*)' {initial}?  { System.out.println("Bad end comment"); if (true) { throw new RuntimeException("Bad end "); } };


TRUE: [t][rR][uU][eE];
FALSE: [f][aA][lL][sS][eE];

CLASS: [cC][lL][aA][sS][sS];
FI: [fF][iI];
IF: [iI][fF];
IN: [iI][nN];
INHERITS: [iI][nN][hH][eE][rR][iI][tT][sS];
ISVOID: [iI][sS][vV][oO][iI][dD];
LET: [lL][eE][tT];
LOOP: [lL][oO][oO][pP];
POOL: [pP][oO][oO][lL];
THEN: [tT][hH][eE][nN];
ELSE: [eE][lL][sS][eE];
WHILE: [wW][hH][iI][lL][eE];
CASE: [cC][aA][sS][eE];
ESAC: [eE][sS][aA][cC];
NEW: [nN][eE][wW];
OF: [oO][fF];
NOT: [nN][oO][tT];

TYPE: [A-Z][_A-Za-z0-9]*;
ID:  [a-z][_A-Za-z0-9]*;
INT_CONST: [0-9][0-9]*;

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMI: ';';
COLON: ':';
ASSIGN: '<-';
DARROW: '=>';
NEG: '~';
COMMA: ',';
PERIOD: '.';
AT: '@';
MUL: '*';
ADD: '+';
MINUS: '-';
DIV: '/';
LT: '<';
LEQ: '<=';
EQ: '=';

STR_CONST:   '"' ( ESC | .)*? '"';


fragment
ESC: '\\"' | '\\\\' ;
