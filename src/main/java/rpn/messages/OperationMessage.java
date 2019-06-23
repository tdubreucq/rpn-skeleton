package rpn.messages;

import java.util.Stack;

public class OperationMessage implements Message {

    private final String operation;
    private final String expressionId;
    public Stack<Double> Numbers;

    public OperationMessage(String token, String expressionId, Stack<Double> numbers) {
        this.operation = token;
        this.expressionId = expressionId;
        this.Numbers = numbers;
    }

    @Override
    public String eventType() {
        return this.operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getExpressionId() {
        return expressionId;
    }
}
