package rpn;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static ArrayList<String> operandsList = new ArrayList<String>();
    private static Stack<Double> numbers = new Stack<Double>();

    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));
        System.out.println("About to evaluate '" + expression + "'");
        double result = evaluate(expression);
        if (numbers.size() == 1) System.out.println("> " + result);
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
        if (operandsList.isEmpty()) populateOperands();
        String[] expressions = expression.split(" ");
        for (String character : expressions) {
            System.out.println(character);
            if (isNumber(character)) numbers.push(Double.parseDouble(character));
            if (isOperand(character) && numbers.size() >=2 ) numbers.push(calculate(character));
        }
        return numbers.pop();
    }

    static boolean isNumber(String toTest) {
        try {
            Double.parseDouble(toTest);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isOperand(String toTest) {
        for (String operand : operandsList) {
            if (operand.equalsIgnoreCase(toTest)) return true;
        }
        return false;
    }

    static void populateOperands() {
        operandsList.add("+");
        operandsList.add("-");
        operandsList.add("*");
        operandsList.add("/");
    }

    static double calculate(String operand) {
        return CalcUtils.evaluateCalc(numbers.pop(),numbers.pop(),operand);
    }

    static Stack<Double> reverse(Stack<Double> toReverse) {
        Stack<Double> toReturn = new Stack<Double>();
        while (!toReverse.isEmpty()) {
            toReturn.push(toReverse.pop());
        }
        return toReturn;
    }
}
