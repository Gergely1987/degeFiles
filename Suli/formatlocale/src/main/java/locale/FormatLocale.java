package locale;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatLocale {


    public String formatCurrency(Double amount, Locale locale){
        if(localePresent(locale)){
            String s="$"+String.valueOf(amount);
            return s;
        }

            throw new NullPointerException("Locale must not be null");

    }

    public String formatCurrencyByLanguage(Double amount, String language, String region){

        if(isEmpty(language) || isEmpty(region)){
            throw new IllegalArgumentException("Incorrect arguments!");
        }
        NumberFormat nf=NumberFormat.getNumberInstance(new Locale(language,region));
        String formated=nf.format(amount);
        String s="";
        switch (language){
            case "hu" : s=formated+" Ft";
            break;
            case "en": s="$"+formated;
        }

        return s;
    }

    public String formatPercentage (Double amount, Locale locale){
    if(localePresent(locale)){
        double a=Math.round(100*amount);
        int newAmount=(int)a;
        return String.valueOf(newAmount+"%");
    }
    throw new IllegalArgumentException("not exists");
    }

    public String formatPercentageByLanguage(Double amount, String language, String region){
return formatPercentage(amount,new Locale(language,region));
    }

    public String formatPercentageByLanguage(int amount, String language, String region){
       if(localePresent(new Locale(language,region))){
           return String.valueOf(amount)+"%";
       }
       throw new IllegalArgumentException("Incorrect arguments!");
    }

    public String formatNumber(Double amount, Locale locale){
        NumberFormat nf= NumberFormat.getNumberInstance(locale);
        nf.setMaximumFractionDigits(2);
        return nf.format(amount);

    }


boolean localePresent(Locale locale){
Locale [] locals=Locale.getAvailableLocales();
    for (Locale l:locals) {
        if(l.equals(locale)){
            return true;
        }
    }
    return false;
    }

private boolean isEmpty (String str){
    if(str==null || str.trim().isEmpty()){
        return true;
    }
    return false;
}
}
