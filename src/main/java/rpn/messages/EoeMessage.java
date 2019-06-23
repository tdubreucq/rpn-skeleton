package rpn.messages;

public class EoeMessage implements Message {

    private String expressionId;

    public EoeMessage(String expressionId) {
        this.expressionId = expressionId;
    }

    @Override
    public String eventType() {
        return "eoe";
    }

    public String getExpressionId() {
        return expressionId;
    }
}
