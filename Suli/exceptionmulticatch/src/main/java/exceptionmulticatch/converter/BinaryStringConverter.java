package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray (String str){
       boolean [] igaz={true};
        for (int i = 0; i < str.length()-1; i++) {
            if(str.substring(i,i+1)!="0" || str.substring(i, i+1)!="1"){
                throw new IllegalArgumentException();
            }
        }
return igaz;
    }

    public String booleanArrayToBinaryString (boolean[] bool){
        if(bool.length==0){
            throw new IllegalArgumentException();
        }
        return "yes";
    }
}
