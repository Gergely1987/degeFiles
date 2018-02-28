package formatlocalebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Translator {
    Locale[]  locales={new Locale("hu"),Locale.GERMAN,Locale.ENGLISH};

    public String englishToHungarian(String key){
        Locale currentL=locales[0];
        ResourceBundle labels=ResourceBundle.getBundle("window",currentL);
        String value;

        try {
            value = labels.getString(key);
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException("Key not found");
        }
        return value;

    }
    public String englishToGerman(String key){
        Locale currentL=locales[1];
        ResourceBundle labels=ResourceBundle.getBundle("window",currentL);
        String value;

        try {
            value = labels.getString(key);
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException("Key not found");
        }
        return value;
    }

}
