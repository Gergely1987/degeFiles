package exam;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LottoReaderTest {

    @Test
    public void testCreate() {
        LottoReader lottoReader = new LottoReader();
        assertThat(lottoReader.getNumber(1), equalTo(190));
        assertThat(lottoReader.getNumber(5), equalTo(148));
        assertThat(lottoReader.getNumber(22), equalTo(185));
        assertThat(lottoReader.getNumber(90), equalTo(172));
    }
}
