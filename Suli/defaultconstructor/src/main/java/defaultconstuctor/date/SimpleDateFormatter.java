package defaultconstuctor.date;

public class SimpleDateFormatter {


    public String formatDateString(SimpleDate sd){
        String dateToString=sd.getYear()+"-"+sd.getMonth()+"-"+sd.getDay();
        return dateToString;
    }

 public String formatDateStringByCountryCode(CountryCode cc, SimpleDate sd){
     String dateToString="";

     if(cc.equals(CountryCode.HU)){
         dateToString=sd.getYear()+"-"+sd.getMonth()+"-"+sd.getDay();
     } else if(cc.equals(CountryCode.EN)){
         dateToString=sd.getDay()+"-"+sd.getMonth()+"-"+sd.getYear();
     }else{
         dateToString=sd.getMonth()+"-"+sd.getDay()+"-"+sd.getYear();
     }
     return dateToString;
 }
}
