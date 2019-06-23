package rpn.bus;

import rpn.messages.Message;
import rpn.consumers.Consumer;

public interface Bus {
    void publish(Message message);
    void subscribe(String eventType, Consumer consumer);
}
