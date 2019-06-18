// Generated from /Users/satch/IdeaProjects/StackMachine/AST.g4 by ANTLR 4.7.2
package cs143.reader;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ASTParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ASTVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ASTParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ASTParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASTParser#klass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlass(ASTParser.KlassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodFeature}
	 * labeled alternative in {@link ASTParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodFeature(ASTParser.MethodFeatureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrFeature}
	 * labeled alternative in {@link ASTParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrFeature(ASTParser.AttrFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASTParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(ASTParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(ASTParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticDispatchExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticDispatchExpr(ASTParser.StaticDispatchExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dispatchExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatchExpr(ASTParser.DispatchExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpr(ASTParser.CondExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopExpr(ASTParser.LoopExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(ASTParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(ASTParser.LetExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typCaseExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypCaseExpr(ASTParser.TypCaseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(ASTParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isVoidExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsVoidExpr(ASTParser.IsVoidExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(ASTParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(ASTParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(ASTParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divideExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideExpr(ASTParser.DivideExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(ASTParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpr(ASTParser.LtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(ASTParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leqExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeqExpr(ASTParser.LeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(ASTParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(ASTParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExpr(ASTParser.StrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(ASTParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpr(ASTParser.ObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noExprExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoExprExpr(ASTParser.NoExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code throwExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpr(ASTParser.ThrowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tryCatchExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchExpr(ASTParser.TryCatchExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tryFinallyExpr}
	 * labeled alternative in {@link ASTParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryFinallyExpr(ASTParser.TryFinallyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeType}
	 * labeled alternative in {@link ASTParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(ASTParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeNoType}
	 * labeled alternative in {@link ASTParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNoType(ASTParser.TypeNoTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBottom}
	 * labeled alternative in {@link ASTParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBottom(ASTParser.TypeBottomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASTParser#actuals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActuals(ASTParser.ActualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASTParser#kase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKase(ASTParser.KaseContext ctx);
}