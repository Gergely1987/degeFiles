package exam;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrigonometryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCalcAException() {
        expectedException.expect(IllegalArgumentException.class);
        new Trigonometry().calculateA(10, 0);
    }

    @Test
    public void testCalcAExceptionNegative() {
        expectedException.expect(IllegalArgumentException.class);
        new Trigonometry().calculateA(10, -10);
    }

    @Test
    public void testCalcA() {
        assertThat(Math.round(new Trigonometry().calculateA(10, 28) * 1000) / 1000.0, equalTo(4.695));
    }

    @Test
    public void testCalcBException() {
        expectedException.expect(IllegalArgumentException.class);
        new Trigonometry().calculateB(10, 0);
    }

    @Test
    public void testCalcBExceptionNegative() {
        expectedException.expect(IllegalArgumentException.class);
        new Trigonometry().calculateB(10, -10);
    }

    @Test
    public void testCalcB() {
        assertThat(Math.round(new Trigonometry().calculateB(10, 28) * 1000) / 1000.0, equalTo(8.829));
    }
}
