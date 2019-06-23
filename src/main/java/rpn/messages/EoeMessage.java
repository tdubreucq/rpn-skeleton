package rpn.messages;

public class EoeMessage implements Message {
    private final String TYPE = "eoe";
    private String expressionId;

    public EoeMessage(String expressionId) {
        this.expressionId = expressionId;
    }

    @Override
    public String eventType() {
        return TYPE;
    }

    public String getExpressionId() {
        return expressionId;
    }
}
