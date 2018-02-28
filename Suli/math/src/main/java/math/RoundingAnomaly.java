package math;

import java.util.Random;

public class RoundingAnomaly {
    public double[] randomNumbers(int size, double max, int scale) {
        double[] newArray = new double[size];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Math.random() * max;
            System.out.println(newArray[i]);
        }

        return newArray;
    }

    public static void main(String[] args) {
        RoundingAnomaly ra = new RoundingAnomaly();
        ra.randomNumbers(1000,100000,0);
    }

}
