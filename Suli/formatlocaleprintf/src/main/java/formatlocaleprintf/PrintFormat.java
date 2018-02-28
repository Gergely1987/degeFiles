package formatlocaleprintf;

public class PrintFormat {

    public String formatMessageWithIntegerParameters(String str, Integer j, Integer k){
        if (str.split("%").length > 2) {
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
        return String.format(str, j, k);
    }


    public String printFormattedText(Double number){
        return String.valueOf("/f")
    }
    public String printFormattedText(int count, String fruit){

    }
    public String printFormattedText(int number){

    }
    public String printFormattedText(Integer i, Integer j, Integer k){

    }

}
