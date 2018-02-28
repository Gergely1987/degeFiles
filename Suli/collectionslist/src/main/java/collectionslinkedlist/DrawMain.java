package collectionslinkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DrawMain {

    private int drawCount;
    private int maxNumber;
    private Random random = new Random();


    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less");
        }

        Set<Integer> newSet = new HashSet<>();
        while (newSet.size() != drawCount) {
            int currentNumber = random.nextInt(maxNumber) + 1;
            newSet.add(currentNumber);
        }
        System.out.println(newSet);
        return newSet;
    }

    public static void main(String[] args) {
        DrawMain dm=new DrawMain();
        dm.drawNumbers(5,20);
    }
}
