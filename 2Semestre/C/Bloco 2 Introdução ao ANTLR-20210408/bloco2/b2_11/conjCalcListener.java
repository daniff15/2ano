// Generated from conjCalc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link conjCalcParser}.
 */
public interface conjCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link conjCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(conjCalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link conjCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(conjCalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link conjCalcParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(conjCalcParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link conjCalcParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(conjCalcParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInterset}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInterset(conjCalcParser.ExprIntersetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInterset}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInterset(conjCalcParser.ExprIntersetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSubtract}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSubtract(conjCalcParser.ExprSubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSubtract}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSubtract(conjCalcParser.ExprSubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(conjCalcParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(conjCalcParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnion(conjCalcParser.ExprUnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnion}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnion(conjCalcParser.ExprUnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(conjCalcParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(conjCalcParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(conjCalcParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(conjCalcParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprConj}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprConj(conjCalcParser.ExprConjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprConj}
	 * labeled alternative in {@link conjCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprConj(conjCalcParser.ExprConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link conjCalcParser#conjunto}.
	 * @param ctx the parse tree
	 */
	void enterConjunto(conjCalcParser.ConjuntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link conjCalcParser#conjunto}.
	 * @param ctx the parse tree
	 */
	void exitConjunto(conjCalcParser.ConjuntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link conjCalcParser#elem}.
	 * @param ctx the parse tree
	 */
	void enterElem(conjCalcParser.ElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link conjCalcParser#elem}.
	 * @param ctx the parse tree
	 */
	void exitElem(conjCalcParser.ElemContext ctx);
}