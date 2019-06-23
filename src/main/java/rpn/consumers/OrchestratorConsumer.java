package rpn.consumers;

import rpn.bus.Bus;
import rpn.messages.*;

import java.util.Date;
import java.util.Stack;
import java.util.Timer;

public class OrchestratorConsumer implements Consumer{

    private Stack<Double> Numbers = new Stack<Double>();


    private final Bus bus;
    public OrchestratorConsumer(Bus bus){
        this.bus = bus;
    }

    @Override
    public synchronized void consume(Message message) {
                if (message instanceof TokenMessage){
                    TokenMessage castedMessage = (TokenMessage) message;
                    try{
                        Numbers.push(Double.parseDouble(castedMessage.getToken()));
                    } catch (Exception e){
                        bus.publish(new OperationMessage(castedMessage.getToken(), castedMessage.getExpressionId(), Numbers));

                    }
                }
                else if(message instanceof OperatorResultMessage){
                    //OperatorResultMessage castedMessage = (OperatorResultMessage) message;
                   // Numbers.addAll(castedMessage.Numbers);
                }
                else if (message instanceof EoeMessage){
                    EoeMessage eoeMessage = (EoeMessage) message;
                    bus.publish(new FinalResultMessage(Numbers, eoeMessage.getExpressionId()));
                }

            }
    }
