package rpn.messages;

public class TokenMessage implements Message {
    private final String TYPE = "token";

    private final String token;
    private final String expressionId;

    public TokenMessage(String token, String expressionId) {
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
