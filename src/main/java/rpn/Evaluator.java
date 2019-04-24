package rpn;

import java.util.ArrayList;

public class Evaluator {
    private final ArrayList<String> operandsList = new ArrayList<String>();

    public Evaluator() {
        operandsList.add("+");
        operandsList.add("-");
        operandsList.add("*");
        operandsList.add("/");
    }

    public boolean isNumber(String toTest) {
        try {
            Double.parseDouble(toTest);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isOperand(String toTest) {
        for (String operand : operandsList) {
            if (operand.equalsIgnoreCase(toTest)) return true;
        }
        return false;
    }
}
