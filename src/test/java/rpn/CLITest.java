package rpn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

    String[] argsToTest = {"7"," ","2"," ","-"," ","3"," ","4"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream sysOut;

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void revertStreams() {
        System.setOut(sysOut);
    }

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test(expected = ArithmeticException.class)
    public void should_throws_exception_if_divide_by_zero() { evaluate("7 0 /"); }

    @Test
    public void should_evaluate_negative_division() { assertThat(evaluate("-33 -55 /")).isEqualTo(0.6); }

    @Test
    public void should_multiply_double_digits() { assertThat(evaluate("0.58 -38.46 *")).isEqualTo(-22.3068); }

    @Test
    public void should_evaluate_complex_operation() { assertThat(evaluate("14 8 * -12.54 - 20 3.5 + *")).isEqualTo(2926.6899999999996); }

    @Test
    public void should_evaluate_not_enough_operands() {
        CLI.main(argsToTest);
        assertThat(outContent.toString()).contains("> 5.0 3.0 4.0");
    }

    @Test
    public void should_evaluate_too_much_operands() { assertThat(evaluate("5 8 + 2 * + / * - * /")).isEqualTo(26); }
}