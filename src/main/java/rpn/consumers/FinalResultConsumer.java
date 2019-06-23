package rpn.consumers;

import rpn.messages.FinalResultMessage;
import rpn.messages.Message;

public class FinalResultConsumer implements Consumer {

    @Override
    public void consume(Message message) {
        FinalResultMessage castedmessage = (FinalResultMessage) message;
        System.out.println("> " + castedmessage.numbers.toString());
    }
}
