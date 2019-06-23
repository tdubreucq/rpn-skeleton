package rpn;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {

    public static final void main(String[] args) {
        /*String expression = Stream.of(args).collect(Collectors.joining(" "));
        System.out.println("About to evaluate '" + expression + "'");

        //Tools class instantiation
        Tokenizer tokenizer = new Tokenizer();
        Operators operatorsTool = new Operators();

        List<Token> tokens = tokenizer.tokenize(expression);

        Stack<Number> tokensStack = new Stack<Number>();
        for (Token token : tokens) {
            if (operatorsTool.findOperator(token) == null) {
                tokensStack.push(new Number(token.getExpression()));
            } else if (tokensStack.size() >= 2){
                operatorsTool.findOperator(token).calculate(tokensStack);
            }
        }


        double result = tokensStack.pop().getNumber();

        if (tokensStack.isEmpty()) System.out.println("> " + result);
        else {
            System.out.print("> ");
            Stack<Number> printableStack = reverse(tokensStack);
            while (!printableStack.isEmpty()) {
                System.out.print(printableStack.pop().getNumber() + " ");
            }
            System.out.print(result+" ");
        }*/
    }

    static Stack<Number> reverse(Stack<Number> toReverse) {
        Stack<Number> toReturn = new Stack<Number>();
        while (!toReverse.isEmpty()) {
            toReturn.push(toReverse.pop());
        }
        return toReturn;
    }
}
