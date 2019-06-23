package rpn.consumers;

import rpn.messages.Message;

import java.util.Stack;

public interface Consumer {
    void consume(Message message);
}
