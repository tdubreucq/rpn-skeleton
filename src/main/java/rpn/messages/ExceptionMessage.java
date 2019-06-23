package rpn.messages;

public class ExceptionMessage implements Message {

    public final String exception;
    public final String expressionId;

    public ExceptionMessage(String exception, String expressionId) {
        this.exception = exception;
        this.expressionId = expressionId;
    }

    @Override
    public String eventType() {
        return "exception";
    }

    public String getExpressionId() {
        return expressionId;
    }
}
