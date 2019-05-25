package rpn;

import java.util.Stack;

public class SubOperator implements Operator {
    @Override
    public void calculate(Stack<Number> stack) {
        double a = stack.pop().getNumber();
        double b = stack.pop().getNumber();
        double result = b - a;
        stack.push(new Number(String.valueOf(result)));
    }
}
