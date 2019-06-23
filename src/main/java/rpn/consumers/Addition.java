package rpn.consumers;

import rpn.bus.Bus;
import rpn.messages.Message;

public class Addition implements Consumer {
    private final String TYPE = "+";
    private Bus bus;

    public Addition(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void consume(Message message) {

    }
}
