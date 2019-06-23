package rpn.messages;

import java.util.Stack;

public class OperatorResultMessage implements Message {

    public final Stack<Double> Numbers;
    private final String expressionId;

    public OperatorResultMessage(Stack<Double> Numbers, String expressionId) {
        this.Numbers = Numbers;
        this.expressionId = expressionId;
    }

    @Override
    public String eventType() {
        return "operatorResult";
    }

    public String getExpressionId() {
        return expressionId;
    }
}
