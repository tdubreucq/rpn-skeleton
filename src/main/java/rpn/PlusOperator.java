package rpn;

import java.util.Stack;

public class PlusOperator implements Operator {

    @Override
    public void calculate(Stack<Number> stack) {
        double result = stack.pop().getNumber() + stack.pop().getNumber();
        stack.push(new Number(String.valueOf(result)));
    }
}
