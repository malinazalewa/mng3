import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CalculatorAZ extends CalculatorBaseListener {
    private int result;

    public static void main(String[] args) throws Exception {
        String expression = "((2 + 3) * (4 - 1)) / 2";
        CharStream input = CharStreams.fromString(expression);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        CalculatorAZ listener = new CalculatorAZ();
        walker.walk(listener, tree);
        int result = listener.getResult();
        System.out.println("Result: " + result);
    }

    public Integer getResult() {
        return result;
    }

    @Override
    public void exitExpression(CalculatorParser.ExpressionContext ctx) {
        String expression = ctx.getText();
        result = evaluateExpression(expression);
    }

    private int evaluateExpression(String expression) {
        // Implementacja logiki obliczania wartości wyrażenia arytmetycznego - parser wyrażeń matematycznych z biblioteki exp4j
        ExpressionBuilder builder = new ExpressionBuilder(expression);
        try {
            Expression exp = builder.build();
            double result = exp.evaluate();
            return (int) result;
        } catch (Exception e) {
            System.err.println("Błąd podczas obliczania wyrażenia: " + expression);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void exitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >= 3) {
            int rightOperand;
            if (ctx.getChild(2) instanceof CalculatorParser.PowExpressionContext) {
                rightOperand = evaluateExpression(ctx.getChild(2).getText());
            } else {
                rightOperand = Integer.parseInt(ctx.getChild(2).getText());
            }
            int leftOperand = result;

            if (ctx.TIMES() != null) {
                result = leftOperand * rightOperand;
            } else if (ctx.DIV() != null) {
                result = leftOperand / rightOperand;
            }
        }
    }
    
    @Override
    public void exitPowExpression(CalculatorParser.PowExpressionContext ctx) {
        String expression = ctx.getText();
        int base = result;
        int exponent = evaluateExpression(expression);
        result = (int) Math.pow(base, exponent);
    }

    @Override
    public void exitSignedAtom(CalculatorParser.SignedAtomContext ctx) {
        if (ctx.PLUS() != null) {
            // nothing to do
        } else if (ctx.MINUS() != null) {
            int operand = Integer.parseInt(ctx.children.get(1).getText());
            result = -operand;
        } else { // atom or func
            // nothing to do
        }
    }

    @Override
    public void exitAtom(CalculatorParser.AtomContext ctx) {
        if (ctx.INTEGER() != null) {
            result = Integer.parseInt(ctx.INTEGER().getText());
        } else { // LPAREN expression RPAREN
            // omit parentheses and do nothing else
        }
    }

    @Override
    public void exitFunc(CalculatorParser.FuncContext ctx) {
        if (ctx.funcname().SQRT() != null) {
            int operand = Integer.parseInt(ctx.expression().get(0).getText());
            result = (int) Math.sqrt(operand);
        }
    }
}
