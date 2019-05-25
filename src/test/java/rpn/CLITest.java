package rpn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CLITest {


    String[] argsToTest1 = {"7"," ","2"," ","-"," ","3"," ","4"};
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
        sysOut = null;
    }

    @Test
    public void should_evaluate_single_digit_constant() {
        String[] argsToTest1 = {"5"};
        CLI.main(argsToTest1);
        assertThat(outContent.toString()).contains("> 5");

    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        String[] argsToTest2 = {"17"};
        CLI.main(argsToTest2);
        assertThat(outContent.toString()).contains("> 17");
    }

    @Test
    public void should_evaluate_simple_addition() {

        String[] argsToTest3 = {"5 5 +"};
        CLI.main(argsToTest3);
        assertThat(outContent.toString()).contains("> 10");
        //assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {

        String[] argsToTest4 = {"2 3 5 + +"};
        CLI.main(argsToTest4);
        assertThat(outContent.toString()).contains("> 10");

        //assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test(expected = ArithmeticException.class)
    public void should_throws_exception_if_divide_by_zero() {
        String[] argsToTest5 = {"7 0 /"};
        CLI.main(argsToTest5);

        //evaluate("7 0 /");
    }

    @Test
    public void should_evaluate_negative_division() {
        String[] argsToTest6 = {"-33 -55 /"};
        CLI.main(argsToTest6);
        assertThat(outContent.toString()).contains("> 0.6");

    //    assertThat(evaluate("-33 -55 /")).isEqualTo(0.6);
    }

    @Test
    public void should_multiply_double_digits() {
        String[] argsToTest7 = {"0.58 -38.46 *"};
        CLI.main(argsToTest7);
        assertThat(outContent.toString()).contains("> -22.3068");

        //assertThat(evaluate("0.58 -38.46 *")).isEqualTo(-22.3068);
    }

    @Test
    public void should_evaluate_complex_operation() {
        String[] argsToTest8 = {"14 8 * -12.54 - 20 3.5 + *"};
        CLI.main(argsToTest8);
        assertThat(outContent.toString()).contains("> 2926.6899999999996");

        //assertThat(evaluate("14 8 * -12.54 - 20 3.5 + *")).isEqualTo(2926.6899999999996);
    }

    @Test
    public void should_evaluate_not_enough_operands() {
        String[] argsToTest9 = {"7 2 - 3 4"};
        CLI.main(argsToTest9);
        assertThat(outContent.toString()).contains("> 5.0 3.0 4.0");
    }

    @Test
    public void should_evaluate_too_much_operands() {
        String[] argsToTest10 = {"5 8 + 2 * + / * - * /"};
        CLI.main(argsToTest10);
        assertThat(outContent.toString()).contains("> 26");


        //assertThat(evaluate("5 8 + 2 * + / * - * /")).isEqualTo(26);

    }
}