// Generated from conjCalc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link conjCalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface conjCalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link conjCalcParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(conjCalcParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link conjCalcParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(conjCalcParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInterset}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInterset(conjCalcParser.ExprIntersetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSubtract}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSubtract(conjCalcParser.ExprSubtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(conjCalcParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnion(conjCalcParser.ExprUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAssign(conjCalcParser.ExprAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(conjCalcParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprConj}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprConj(conjCalcParser.ExprConjContext ctx);
	/**
	 * Visit a parse tree produced by {@link conjCalcParser#conjunto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunto(conjCalcParser.ConjuntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link conjCalcParser#elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElem(conjCalcParser.ElemContext ctx);
}