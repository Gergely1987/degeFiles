package guessthenumber;

import java.util.Random;

public class PlayerWhoAsks {

    public static void main(String[] args) {
      PlayerWhoAnswers pwa=new PlayerWhoAnswers(new Random(),100);


        int count=0;
        while(!(pwa.answerTo(50)==Answer.MATCH)){
            pwa=new PlayerWhoAnswers(new Random(), 100);
            pwa.answerTo(50);
            System.out.println(count);
            count++;
        }
    }
}