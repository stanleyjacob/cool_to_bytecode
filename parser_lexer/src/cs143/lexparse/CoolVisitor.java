// Generated from src/cs143/lexparse/Cool.g4 by ANTLR 4.7.2
package cs143.lexparse;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#klass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlass(CoolParser.KlassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method}
	 * labeled alternative in {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(CoolParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(CoolParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(CoolParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#let_formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_formal(CoolParser.Let_formalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(CoolParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dispatch}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatch(CoolParser.DispatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code str_const}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_const(CoolParser.Str_constContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(CoolParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isvoid}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsvoid(CoolParser.IsvoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfdispatch}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfdispatch(CoolParser.SelfdispatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(CoolParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(CoolParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neg}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(CoolParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(CoolParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(CoolParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(CoolParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(CoolParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CoolParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CoolParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(CoolParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code case}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(CoolParser.CaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThanOrEqualTo}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqualTo(CoolParser.LessThanOrEqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(CoolParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(CoolParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_true(CoolParser.Bool_trueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(CoolParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int_const}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_const(CoolParser.Int_constContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_false}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_false(CoolParser.Bool_falseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CoolParser.AssignContext ctx);
}