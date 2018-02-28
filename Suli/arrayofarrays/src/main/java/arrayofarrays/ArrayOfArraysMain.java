package arrayofarrays;

import java.util.Arrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int newArray[][] = new int[size][size];

        for (int i = 1; i < size; i++) {

            for (int j = 1; j < size; j++) {
                newArray[i][j] = i * j;
                System.out.print(newArray[i][j] + ", ");
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(newArray));
        return newArray;
    }

    public int[][] trinangularMatrix(int size) {
        int[][] newArray = new int[size][];

        for (int i = 0; i < size; i++) {
                newArray[i]=new int[i];
            for (int j = 0; j < i; j++) {
                newArray[i][j]=i;
                System.out.print(newArray[i][j]+", ");
            }
            System.out.println();
        }
       // System.out.println(Arrays.deepToString(newArray));
        return newArray;
    }

    public int [][] getValues(){
        int [] months={31,28,31,30,31,30,31,30,31,30,31,30};
        int [][] dailyAvarageTemperature=new int[12][];

        for (int i=0; i<months.length; i++){
            dailyAvarageTemperature[i]=new int[months[i]];
            System.out.println();
            for(int j=0; j<months[i]; j++){
                System.out.print(dailyAvarageTemperature[i][j]);
            }

        }

        return dailyAvarageTemperature;
    }


    public static void main(String[] args) {
        ArrayOfArraysMain aoam = new ArrayOfArraysMain();
        aoam.multiplicationTable(10);
        System.out.println();
        aoam.trinangularMatrix(10);
        aoam.getValues();
    }
}
