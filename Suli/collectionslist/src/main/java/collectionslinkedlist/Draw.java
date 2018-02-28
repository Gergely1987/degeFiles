package collectionslinkedlist;

import java.util.*;

public class Draw {

    private int drawCount;
    private int maxNumber;
    private Random random = new Random();


    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less");
        }

        Set<Integer> newSet = new TreeSet<>();
        while (newSet.size() != drawCount) {
            int currentNumber = random.nextInt(maxNumber) + 1;
            newSet.add(currentNumber);
        }
   return newSet;


    }
}
