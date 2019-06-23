package rpn.consumers;

import rpn.messages.Message;

public interface Consumer {
    void consume(Message message);
}
