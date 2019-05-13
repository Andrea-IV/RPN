package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.evaluate;

public class CLITest {

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

    @Test
    public void should_evaluate_simple_subtraction() {
        assertThat(evaluate("17 5 -")).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_subtraction() {
        assertThat(evaluate("2 3 5 - -")).isEqualTo(4);
    }

    @Test
    public void should_evaluate_simple_time() {
        assertThat(evaluate("17 5 *")).isEqualTo(85);
    }

    @Test
    public void should_evaluate_more_complex_time() {
        assertThat(evaluate("2 3 5 * *")).isEqualTo(30);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("17 5 /")).isEqualTo(3.4);
    }

    @Test
    public void should_evaluate_more_complex_division() {
        assertThat(evaluate("2 20 5 / /")).isEqualTo(0.5);
    }

    @Test
    public void should_evaluate_simple_negative() {
        assertThat(evaluate("17 -5 /")).isEqualTo(-3.4);
    }

    @Test
    public void should_evaluate_more_complex_negative() {
        assertThat(evaluate("-2 20 -5 / /")).isEqualTo(0.5);
    }

    @Test
    public void should_evaluate_simple_decimal() {
        assertThat(evaluate("17.5 5 /")).isEqualTo(3.5);
    }

    @Test
    public void should_evaluate_more_complex_decimal() {
        assertThat(evaluate("2 20.6 5 + *")).isEqualTo(51.2);
    }

    @Test
    public void should_evaluate_varied_calculation() {
        assertThat(evaluate("20 5 /")).isEqualTo(4);
        assertThat(evaluate("5 2 3 + -")).isEqualTo(0);
        assertThat(evaluate("4 2 + 3 -")).isEqualTo(3);
        assertThat(evaluate("3 5 8 * 7 + *")).isEqualTo(141);
    }
}