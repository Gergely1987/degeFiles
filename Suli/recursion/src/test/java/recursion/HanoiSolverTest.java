package recursion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class HanoiSolverTest {

    @Test
    public void oneDisk() {
        String expectedSteps = "A->C";

        HanoiSolver hanoiGamer = new HanoiSolver();
        hanoiGamer.moveDisks(1, 'A', 'C', 'B');
        String actualSteps = hanoiGamer.getResultOfGame();
        assertThat(actualSteps, equalTo(expectedSteps));
    }

    @Test
    public void moreDisks() {
        String expectedSteps = "A->CA->BC->BA->CB->AB->CA->CA->BC->BC->AB->AC->BA->CA->BC->BA->CB->AB->CA->CB->AC->BC->AB->AB->CA->CA->BC->BA->CB->AB->CA->C";

        HanoiSolver hanoiGamer = new HanoiSolver();
        hanoiGamer.moveDisks(5, 'A', 'C', 'B');
        String actualSteps = hanoiGamer.getResultOfGame();
        assertThat(actualSteps, equalTo(expectedSteps));
    }
}
