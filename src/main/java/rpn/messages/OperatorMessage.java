package rpn.messages;

public class OperatorMessage implements Message {
    private final String TYPE = "operator";

    private final String token;
    private final String expressionId;

    public OperatorMessage(String token, String expressionId) {
        this.token = token;
        this.expressionId = expressionId;
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
