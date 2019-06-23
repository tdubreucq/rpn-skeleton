package rpn.messages;

public class ResultMessage implements Message {
    private final String TYPE = "result";

    private final String token;
    private final String expressionId;

    public ResultMessage(String token, String expressionId) {
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
