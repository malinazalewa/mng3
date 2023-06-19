// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(CalculatorParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(CalculatorParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(CalculatorParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(CalculatorParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(CalculatorParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(CalculatorParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(CalculatorParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(CalculatorParser.FuncnameContext ctx);
}