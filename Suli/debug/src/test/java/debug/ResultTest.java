package debug;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResultTest {
    
    Result result = new Result(ResultType.FOUND, 1, 2, 5, 3, 5);
    
    @Test
    public void testCreateResult() {
       
       assertThat(result.getResultType(),is(ResultType.FOUND));
       assertThat(result.getWinner(),is(1));
       assertThat(result.getX1(),is(2));
       assertThat(result.getY1(),is(5));
       assertThat(result.getX2(),is(3));
       assertThat(result.getY2(),is(5));
       
    }
}
