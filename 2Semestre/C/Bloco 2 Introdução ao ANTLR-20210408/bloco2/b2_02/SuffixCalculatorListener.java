// Generated from SuffixCalculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SuffixCalculatorParser}.
 */
public interface SuffixCalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SuffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SuffixCalculatorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SuffixCalculatorParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SuffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SuffixCalculatorParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SuffixCalculatorParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numbers}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumbers(SuffixCalculatorParser.NumbersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numbers}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumbers(SuffixCalculatorParser.NumbersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code operators}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperators(SuffixCalculatorParser.OperatorsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operators}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperators(SuffixCalculatorParser.OperatorsContext ctx);
}