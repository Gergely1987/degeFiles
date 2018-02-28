package guessthenumber;

import java.util.Random;

public class PlayerWhoAnswers {

    Random ran=new Random();
    private int number=ran.nextInt();

//    public PlayerWhoAnswers(int number,100) {
//        this.number = ran.nextInt();
//    }

    public PlayerWhoAnswers(Random ran, int number) {
        this.ran = ran;
        this.number = number;
    }

    public Answer answerTo(int askedNumber){
        if(askedNumber>number){
           // System.out.println("több");
            return Answer.MORE;
        } else if(askedNumber<number){
           // System.out.println("kevesebb");
            return Answer.LESS;
        } else{
           // System.out.println("megegyezik");
            return Answer.MATCH;
        }
    }
}
