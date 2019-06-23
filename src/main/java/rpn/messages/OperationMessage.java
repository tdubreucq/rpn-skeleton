package rpn.messages;

import java.util.Stack;

public class OperationMessage implements Message {
    private final String TYPE = "operation";

    private final String token;
    private final String expressionId;
    private Stack<Double> numbers;

    public OperationMessage(String token, String expressionId, Stack<Double> numbers) {
        this.token = token;
        this.expressionId = expressionId;
        this.numbers = numbers;
    }

    @Override
    public String eventType() {
        return TYPE;
    }

    public String getToken() {
        return token;
    }

    public String getExpressionId() {
        return expressionId;
    }
}
