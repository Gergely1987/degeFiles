package controliteration.conwaysgame;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConwaysGameTest {

    @Test
    public void loneliness() {
        boolean[][] start = {{false, false, false},
                            {false, true, false},
                            {false, false, false}};
        boolean[][] stop = {{false, false, false},
                {false, false, false},
                {false, false, false}};
        ConwaysGame conwaysGame = new ConwaysGame(start);
        conwaysGame.next();
        assertThat(conwaysGame.getTable(), equalTo(stop));
    }

    @Test
    public void overcrowding() {
        boolean[][] start = {{false, true, true},
                {true, true, true},
                {false, false, false}};
        boolean[][] stop = {{true, false, true},
                {true, false, true},
                {false, true, false}};
        ConwaysGame conwaysGame = new ConwaysGame(start);
        conwaysGame.next();
        assertThat(conwaysGame.getTable(), equalTo(stop));
    }

    @Test
    public void stasis() {
        boolean[][] start = {{false, false, false},
                {false, true, true},
                {false, true, false}};
        boolean[][] stop = {{false, false, false},
                {false, true, true},
                {false, true, true}};
        ConwaysGame conwaysGame = new ConwaysGame(start);
        conwaysGame.next();
        assertThat(conwaysGame.getTable(), equalTo(stop));
    }

    @Test
    public void blinker() {
        boolean[][] start = {{false, false, false},
                {true, true, true},
                {false, false, false}};
        boolean[][] stop = {{false, true, false},
                {false, true, false},
                {false, true, false}};
        ConwaysGame conwaysGame = new ConwaysGame(start);
        conwaysGame.next();
        assertThat(conwaysGame.getTable(), equalTo(stop));
    }
}
