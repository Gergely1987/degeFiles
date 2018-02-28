package locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FormatLocaleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void nullLocaleCurrencyShouldThrowException() throws NullPointerException {
        //Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        new FormatLocale().formatCurrency(10.52, null);
    }

    @Test
    public void nullLocalePercentageShouldThrowException() throws NullPointerException {
        //Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        new FormatLocale().formatCurrency(10.52, null);
    }

    @Test
    public void incorrectArgumentShouldThrowException() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect arguments!");
        // When
        new FormatLocale().formatCurrencyByLanguage(10.25, "", "");
    }

    @Test
    public void nonSupportedLocaleShouldThrowException() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect arguments!");
        // When
        new FormatLocale().formatPercentageByLanguage(95, "aa", "AA");
    }

    @Test
    public void testFormatCurrencyByLocale() {

        assertThat(new FormatLocale().formatCurrency(10.25, Locale.US), equalTo("$10.25"));
    }

    @Test
    public void testFormatCurrencyByLanguage() {

        assertThat(new FormatLocale().formatCurrencyByLanguage(10.25, "en", "US"), equalTo("$10.25"));
        assertThat(new FormatLocale().formatCurrencyByLanguage(10.25, "hu", "HU"), equalTo("10,25 Ft"));
    }

    @Test
    public void testFormatPercentageByLocale() {

        assertThat(new FormatLocale().formatPercentage(0.545, Locale.US), equalTo("55%"));
    }

    @Test
    public void testFormatPercentageByLanguage() {

        assertThat(new FormatLocale().formatPercentageByLanguage(0.545, "en", "US"), equalTo("55%"));
        assertThat(new FormatLocale().formatPercentageByLanguage(0.545, "hu", "HU"), equalTo("55%"));
    }

    @Test
    public void testNumberFormatting() {

        assertThat(new FormatLocale().formatNumber(546389.3456, Locale.US), equalTo("546,389.35"));
    }
}
