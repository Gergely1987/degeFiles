package week;

public class DayOfWeeks {

    public String whichDay(String day) {
        String say = "";
        switch (day.toLowerCase()) {
            case "hétfő":
                say = "hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                say = "hét közepe";
                break;
            case "péntek":
                say = "majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                say = "hét vége";
                break;
            default: throw new IllegalArgumentException("Invalid day: "+day);
        }


        return say;
    }

}
