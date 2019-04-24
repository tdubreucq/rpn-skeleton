package rpn;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    private static Stack<Double> numbers = new Stack<Double>();

    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));
        System.out.println("About to evaluate '" + expression + "'");
        double result = evaluate(expression);
        if (numbers.size() == 0) System.out.println("> " + result);
        else {
            System.out.print("> ");
            Stack<Double> printableStack = reverse(numbers);
            while (!printableStack.isEmpty()) {
                System.out.print(printableStack.pop() + " ");
            }
            System.out.print(result+" ");
        }
    }

    static double evaluate(String expression) {
        Evaluator evaluator = new Evaluator();
        String[] expressions = expression.split(" ");
        for (String character : expressions) {
            if (evaluator.isNumber(character)) numbers.push(Double.parseDouble(character));
            if (evaluator.isOperand(character) && numbers.size() >=2 ) numbers.push(calculate(character));
        }
        return numbers.pop();
    }

    static double calculate(String operand) {
        Operation toCalc = new Operation(numbers.pop(), numbers.pop(), operand);
        return toCalc.evaluateCalc();
    }

    static Stack<Double> reverse(Stack<Double> toReverse) {
        Stack<Double> toReturn = new Stack<Double>();
        while (!toReverse.isEmpty()) {
            toReturn.push(toReverse.pop());
        }
        return toReturn;
    }
}
