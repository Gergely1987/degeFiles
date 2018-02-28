package exceptionmulticatch.converter;

import java.text.ParseException;

public class ProbaParser {

    public static final String SEPARATOR=",";
    String [] ez=new String[3];
    String [] az=new String[3];

    public Proba parse(String line){
       try {
           String[] field = line.split(SEPARATOR);
           return new Proba(ez[0], Integer.parseInt(az[0]));
       }
       catch(NullPointerException | IllegalArgumentException | IndexOutOfBoundsException ne){
           throw new IllegalArgumentException("not valid");
        }
    }

    @Override
    public String toString() {
        return ez+" és "+az;
    }
}
