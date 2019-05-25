package rpn;

class Operators {

    Operator findOperator(Token token) {
        switch(token.getExpression()) {
            case "+":
                return new PlusOperator();
            case "-":
                return new SubOperator();
            case "/":
                return new DivideOperator();
            case "*":
                return new MultiplyOperator();
        }

        return null;
    }
}
