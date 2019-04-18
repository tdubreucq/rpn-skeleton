package rpn;

public final class CalcUtils {
    
    public static double add(double a, double b) {
        return a+b;
    }
    
    public static double substract(double a, double b) {
        return b-a;
    }
    
    public static double multiply(double a, double b) {
        return a*b;
    }
    
    public static double divide(double a, double b) {
        return (b == 0) ? a : b/a;
    }

    public static double evaluateCalc(double a, double b, String operand) {
        switch (operand) {
            case "+":
                return add(a, b);
            case "-":
                return substract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
        }
        throw new IllegalArgumentException();
    }
}
