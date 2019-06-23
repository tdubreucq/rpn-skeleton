package rpn.consumers;

import rpn.bus.Bus;
import rpn.messages.ExceptionMessage;
import rpn.messages.Message;
import rpn.messages.OperationMessage;
import rpn.messages.OperatorResultMessage;

public class Multiplication implements Consumer {
    private final String TYPE = "*";
    private Bus bus;


    public Multiplication(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void consume(Message message) {
        OperationMessage castedMessage = (OperationMessage) message;
        if (castedMessage.Numbers.size() < 2){
            bus.publish(new ExceptionMessage("Not enough number in stack", castedMessage.getExpressionId()));
        }else{
            castedMessage.Numbers.push( castedMessage.Numbers.pop() * castedMessage.Numbers.pop());


            bus.publish(new OperatorResultMessage(castedMessage.Numbers, castedMessage.getExpressionId()));
        }
    }
}
