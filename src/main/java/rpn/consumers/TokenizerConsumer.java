package rpn.consumers;

import rpn.bus.Bus;
import rpn.consumers.Consumer;
import rpn.messages.EoeMessage;
import rpn.messages.ExpressionMessage;
import rpn.messages.Message;
import rpn.messages.TokenMessage;

import java.util.stream.Stream;

public class TokenizerConsumer implements Consumer {

    private final Bus bus;

    public TokenizerConsumer(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void consume(Message message) {

        ExpressionMessage expressionMessage = (ExpressionMessage) message;
        String expression = expressionMessage.expression();
        Stream.of(expression.split("\\s+"))
            .forEach(s -> bus.publish(new TokenMessage(s,expressionMessage.expressionId())));

        bus.publish(new EoeMessage(expressionMessage.expressionId()));
    }
}
