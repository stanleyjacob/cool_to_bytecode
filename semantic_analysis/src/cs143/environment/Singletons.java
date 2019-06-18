package cs143.environment;

import cs143.ast.Expr;
import cs143.ast.NoExprExpr;

public class Singletons {

    // intern() on manifest constant is unnecessary

    public static String NOTYPE = "_no_type";

    public static Expr NOEXPR = new NoExprExpr(0, NOTYPE);

    public static String PLUS = "_plus";

    public static String SELF = "self";

    public static String SELF_TYPE = "SELF_TYPE";

    public static String OBJECT = "Object";

    public static String BOTTOM = "Bottom";

    public static String STRING = "String";

    public static String INT = "Int";

    public static String BOOLEAN = "Bool";

    public static String IO = "IO";

    public static String RETURN = "_return";

    public static String LT = "_lt";

    public static String VOID = "Void";
}
