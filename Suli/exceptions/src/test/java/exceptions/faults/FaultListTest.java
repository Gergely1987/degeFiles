package exceptions.faults;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FaultListTest {

    private static final String[] INPUT = {
            "1,12.4,1998.04.12.",
            "2,12.4,1998.04.12.,a",
            "a,12.4,1998.04.12.",
            "3,12a.4,1998.04.12.",
            "4,12.4,1998.12.1.",
            "5,12.4,1998.04.3a.",
            "a1,12a.4,1998.04.12.",
            "6,12a.4,1998.04a.12."
    };
    private static final ProcessingResult[] INPUT_RESULT = {
            ProcessingResult.NO_ERROR,
            ProcessingResult.WORD_COUNT_ERROR,
            ProcessingResult.COMMENT,
            ProcessingResult.VALUE_ERROR,
            ProcessingResult.NO_ERROR,
            ProcessingResult.DATE_ERROR,
            ProcessingResult.COMMENT,
            ProcessingResult.VALUE_AND_DATE_ERROR
    };

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void processingNullParamShouldThrowException() throws Exception {
        exception.expect(IllegalArgumentException.class);

        new FaultList().processing(null);
    }

    @Test
    public void processing() {
        FaultList faultList = new FaultList();
        List<String> faults = faultList.processing(INPUT);

        List<String> expected = new ArrayList<>();
        expected.add("2," + INPUT_RESULT[1].getCode());
        expected.add("3," + INPUT_RESULT[3].getCode());
        expected.add("5," + INPUT_RESULT[5].getCode());
        expected.add("6," + INPUT_RESULT[7].getCode());

        assertThat(faults, is(expected));
    }

}