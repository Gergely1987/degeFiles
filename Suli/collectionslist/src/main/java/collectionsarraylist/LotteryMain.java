package collectionsarraylist;

import java.util.*;

public class LotteryMain {

    private int lotteryType;
    private int ballCount;
    private Random random=new Random();
    int a=0;
    public LotteryMain() {
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

    public static void main(String[] args) {
        LotteryMain lm=new LotteryMain();
        lm.selectWinningNumbers(5,10);
    }
}
