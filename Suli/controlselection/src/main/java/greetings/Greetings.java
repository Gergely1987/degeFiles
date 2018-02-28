package greetings;

import java.time.LocalTime;
import java.time.ZoneId;

public class Greetings {


    public String greet(int a, int b) {
        String greating = "";

        if ((a > 5 && b >= 0 && a < 9) || (a == 9 && b == 0)||(a==5&&b>0)) {
            greating = "jó reggelt";

        } else if ((a == 9 && b > 0) || (a > 9 && a < 18) || (a == 18 && b <= 30)) {
            greating = "jó napot";
        } else if ((a == 18 && b > 30) || (a > 18 && a < 20) || (a == 20 && b == 0))
            greating = "jó estét";
        else {
            greating = "jó éjt";
        }
        return greating;
    }

    public static void main(String[] args) {
        Greetings g = new Greetings();
        g.greet(5, 10);
    }


}
