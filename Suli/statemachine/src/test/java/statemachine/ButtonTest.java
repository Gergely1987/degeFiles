package statemachine;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ButtonTest {

@Test
    public void stateChangeFromOne(){
    assertThat(Button.HEATING1.nextLevel(),equalTo(Button.TURNOFF_ON));
}

@Test
    public void stateChangeFromTurnoff_On(){
    assertThat(Button.TURNOFF_ON.nextLevel(), equalTo(Button.HEATING3));
}
}
