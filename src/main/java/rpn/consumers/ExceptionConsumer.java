package rpn.consumers;

import rpn.messages.ExceptionMessage;
import rpn.messages.FinalResultMessage;
import rpn.messages.Message;

public class ExceptionConsumer implements Consumer {

    @Override
    public void consume(Message message) {
        ExceptionMessage castedmessage = (ExceptionMessage) message;
        System.out.println("Exception on " + castedmessage.getExpressionId() + " : " + castedmessage.exception);
    }
}
