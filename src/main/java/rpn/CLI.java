package rpn;

import rpn.bus.InMemoryBus;
import rpn.consumers.*;
import rpn.messages.ExpressionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {

    public static final void main(String[] args) {
        InMemoryBus bus = new InMemoryBus();
        bus.subscribe("expression", new TokenizerConsumer(bus));

        OrchestratorConsumer orchestratorConsumer = new OrchestratorConsumer(bus);

        bus.subscribe("token", orchestratorConsumer);
        bus.subscribe("operatorResult", orchestratorConsumer);
        bus.subscribe("eoe", orchestratorConsumer);

        bus.subscribe("+", new Addition(bus));
        bus.subscribe("-", new Substraction(bus));
        bus.subscribe("/", new Division(bus));
        bus.subscribe("*", new Multiplication(bus));
        bus.subscribe("exception", new ExceptionConsumer());
        bus.subscribe("finalresult", new FinalResultConsumer());
        String arguments = Arrays.toString(args);
        arguments = arguments.substring(1, arguments.length()-1).replace(",", "");
        ExpressionMessage expressionMessage = new ExpressionMessage(arguments, "1");

        bus.publish(expressionMessage);
    }
}
