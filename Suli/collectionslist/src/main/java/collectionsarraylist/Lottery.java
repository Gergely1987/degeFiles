package collectionsarraylist;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

public class Lottery {

    private int lotteryType;
    private int ballCount;
    private Random random=new Random();

    public Lottery() {
    }

    public int getLotteryType() {
        return lotteryType;
    }

    public int getBallCount() {
        return ballCount;
    }

    private List<Integer>winningNumbers=new ArrayList<>();
    private int currentNumber=0;

    public List<Integer>selectWinningNumbers(int lotteryType, int ballCount){
        if(lotteryType>=ballCount){
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        for (int i = 0; i <lotteryType; i++) {
            currentNumber=random.nextInt(ballCount);
            while(winningNumbers.contains(currentNumber)){
                currentNumber=random.nextInt(ballCount);
            }
            winningNumbers.add(currentNumber);
        }
        System.out.println(winningNumbers);
        winningNumbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(winningNumbers);
        return winningNumbers;
    }



}
