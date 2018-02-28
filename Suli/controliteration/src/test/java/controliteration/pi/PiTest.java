package controliteration.pi;

import org.junit.Test;
import pigenerator.PiGenerator;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PiTest {

    @Test
    public void getPi() {
        assertThat(new PiGenerator().getPi(), equalTo(new BigDecimal("3.141592653589793238462643383279")));
    }
}
