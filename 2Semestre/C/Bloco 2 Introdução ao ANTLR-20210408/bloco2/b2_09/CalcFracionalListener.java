// Generated from CalcFracional.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcFracionalParser}.
 */
public interface CalcFracionalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcFracionalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CalcFracionalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracionalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CalcFracionalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcFracionalParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CalcFracionalParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracionalParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CalcFracionalParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcFracionalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CalcFracionalParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracionalParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CalcFracionalParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(CalcFracionalParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(CalcFracionalParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRead(CalcFracionalParser.ExprReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRead}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRead(CalcFracionalParser.ExprReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPotencia}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPotencia(CalcFracionalParser.ExprPotenciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPotencia}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPotencia(CalcFracionalParser.ExprPotenciaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(CalcFracionalParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(CalcFracionalParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(CalcFracionalParser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(CalcFracionalParser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnitario}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnitario(CalcFracionalParser.ExprUnitarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnitario}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnitario(CalcFracionalParser.ExprUnitarioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(CalcFracionalParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(CalcFracionalParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReduce(CalcFracionalParser.ExprReduceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReduce(CalcFracionalParser.ExprReduceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFraction}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFraction(CalcFracionalParser.ExprFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFraction}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFraction(CalcFracionalParser.ExprFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(CalcFracionalParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link CalcFracionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(CalcFracionalParser.ExprMultDivModContext ctx);
}