package rpn.messages;

import java.util.Stack;

public class FinalResultMessage implements Message {

    public final Stack<Double> numbers ;
    private final String expressionId;

    public FinalResultMessage(Stack<Double> result, String expressionId) {
        this.numbers = result;
        this.expressionId = expressionId;
    }

    @Override
    public String eventType() {
        return "finalresult";
    }

    public String getExpressionId() {
        return expressionId;
    }
}
