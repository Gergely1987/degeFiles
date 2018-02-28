package formatlocalemessage;


import java.text.MessageFormat;

public class MessageGenerator {

    public String generateForecastText(String weather, int degree, String place){
     //("Tomorrow expect light rain with 12  \u00B0C temperature in Budapest.");
    String result= MessageFormat.format("Tomorrow expect {0} with {1}  \u00B0C temperature in {2}.",weather,degree,place);
return result;
    }
    public String generateLotteryAnnouncement(String name){
//"Yesterday John Smith won a staggering sum of 500 M"
        return MessageFormat.format("Yesterday {0} won a staggering sum of 500 M",name);
    }

}
