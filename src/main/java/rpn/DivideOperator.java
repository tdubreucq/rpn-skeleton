package rpn;

import java.util.Stack;

public class DivideOperator implements Operator {
    @Override
    public void calculate(Stack<Number> stack) {
        double firstNumber = stack.pop().getNumber();
        if (firstNumber == 0) {
            throw new ArithmeticException("You can't divide by zero.");
        }
        double result = stack.pop().getNumber()/firstNumber;
        stack.push(new Number(String.valueOf(result)));
    }
}
