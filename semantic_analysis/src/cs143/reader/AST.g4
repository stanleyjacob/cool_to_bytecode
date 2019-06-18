grammar AST;
import Lexemes;

program: LINENO PROGRAM klass+;

klass: LINENO CLASS ID ID STR_CONST LPAREN feature* RPAREN;

feature: LINENO METHOD ID  formal* ID expr         #methodFeature
       | LINENO ATTR ID ID expr                    #attrFeature
       ;

formal: LINENO FORMAL ID ID;

// TODO: rename type to semtype

expr:  LINENO ASSIGN ID expr type                   #assignExpr
    |  LINENO STATIC_DISPATCH expr ID ID actuals type   #staticDispatchExpr
    |  LINENO DISPATCH expr ID actuals type         #dispatchExpr
    |  LINENO COND expr expr expr type              #condExpr
    |  LINENO LOOP expr expr type                   #loopExpr
    |  LINENO BLOCK expr+ type                      #blockExpr
    |  LINENO LET ID ID expr expr type              #letExpr
    |  LINENO TYPCASE expr kase+ type               #typCaseExpr
    |  LINENO NEW ID type                           #newExpr
    |  LINENO ISVOID expr type                      #isVoidExpr
    |  LINENO PLUS expr expr type                   #plusExpr
    |  LINENO SUB expr expr type                    #subExpr
    |  LINENO MUL expr expr type                    #mulExpr
    |  LINENO DIVIDE expr expr type                 #divideExpr
    |  LINENO NEG expr type                         #negExpr
    |  LINENO LT expr expr type                     #ltExpr
    |  LINENO EQ expr expr type                     #eqExpr
    |  LINENO LEQ expr expr type                    #leqExpr
    |  LINENO COMP expr type                        #compExpr
    |  LINENO INT INT_CONST type                    #intExpr
    |  LINENO STR STR_CONST type                    #strExpr
    |  LINENO BOOL INT_CONST type                   #boolExpr
    |  LINENO OBJECT ID type                        #objectExpr
    |  LINENO NO_EXPR type                          #noExprExpr
    |  LINENO THROW expr type                       #throwExpr
    |  LINENO TRY_CATCH expr ID expr type           #tryCatchExpr
    |  LINENO TRY_FINALLY expr expr type            #tryFinallyExpr
    ;

type: COLON ID             #typeType
    | COLON NO_TYPE        #typeNoType
    | COLON BOTTOM         #typeBottom
    ;

actuals: LPAREN  expr*  RPAREN;

kase: LINENO BRANCH ID ID expr;

