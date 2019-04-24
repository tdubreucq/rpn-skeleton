package rpn;

public class Operation {
    private double first, second;
    private String operand;

    public Operation (double a, double b, String o) {
        this.first = a;
        this.second = b;
        this.operand = o;
    }

    public double add(double a, double b) {
        return a+b;
    }

    public double substract(double a, double b) {
        return b-a;
    }

    public double multiply(double a, double b) {
        return a*b;
    }

    public double divide(double a, double b) {
        if (a == 0) {
            throw new ArithmeticException("You can't divide by zero.");
        }
        else {
            return b/a;
        }
    }

    public double evaluateCalc() {
        switch (operand) {
            case "+":
                return add(first, second);
            case "-":
                return substract(first, second);
            case "*":
                return multiply(first, second);
            case "/":
                return divide(first, second);
        }
        throw new IllegalArgumentException();
    }
}
