package rpn;

public class Number {

    private double number;

    public Number(String expression) {
        this.number = Double.parseDouble(expression);
    }

    public double getNumber() {
        return this.number;
    }
}
