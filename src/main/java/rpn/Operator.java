package rpn;

import java.util.Stack;

public interface Operator {

    public abstract void calculate(Stack<Number> stack);
}
