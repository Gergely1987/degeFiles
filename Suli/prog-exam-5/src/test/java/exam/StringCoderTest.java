package exam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringCoderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNull() {
        expectedException.expect(NullPointerException.class);
        new StringCoder().encode(null);
    }

    @Test
    public void testEncode() {
        assertThat(new StringCoder().encode(""), equalTo(""));
        assertThat(new StringCoder().encode("a"), equalTo("1a"));
        assertThat(new StringCoder().encode("aa"), equalTo("2a"));
        assertThat(new StringCoder().encode("aab"), equalTo("2a1b"));
        assertThat(new StringCoder().encode("aabb"), equalTo("2a2b"));
        assertThat(new StringCoder().encode("ab"), equalTo("1a1b"));
        assertThat(new StringCoder().encode("abb"), equalTo("1a2b"));
        assertThat(new StringCoder().encode("abc"), equalTo("1a1b1c"));
    }
}
