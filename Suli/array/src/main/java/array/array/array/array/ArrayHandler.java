package array.array.array.array;

import java.util.Arrays;

public class ArrayHandler {
    public static void toUppercase(String s) {
        System.out.println(s.toUpperCase());
    }

    public static int[] append(int[] source, int item) {
        int[] uj = new int[source.length + 1];
        uj[uj.length - 1] = item;

        for (int i = 0; i < uj.length - 1; i++) {
            uj[i] = source[i];

        }
        for (int i = 0; i < uj.length; i++) {
            System.out.print(uj[i] + ", ");
        }

        return uj;
    }

    public static int[] append2(int[] source, int item) {
        int[] target = new int[source.length + 1];

        System.arraycopy(source, 0, target, 0, target.length - 1);
        target[target.length - 1] = item;

        return target;
    }

    public static boolean contains(int[] source, int item) {
        boolean igaz = false;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == item) {
                igaz = true;
                break;
            } else {
                igaz = false;
            }
        }
        return igaz;
    }

    public static int find(int[] source, int item) {
        int a = -1;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == item) {
                a = i;
            }
        }

        return a;
    }

    public static int[] insert(int[] source, int index, int item) {
        int[] newArray = new int[source.length];

        System.arraycopy(source, 0, newArray, 0, newArray.length);
        newArray[index] = item;
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }


        return newArray;
    }

    public static int[] insertTogether(int[] source, int index, int item) {
        int[] newArray = new int[source.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = source[i];
        }


        for (int i = newArray.length - 1; i > index; i--) {
            newArray[i] = source[i - 1];
        }
        newArray[index] = item;

        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
        return newArray;
    }


    public static int[] insertAll(int[] source, int start, int[] items) {
        int[] newArray = new int[source.length + items.length];

        System.arraycopy(source, 0, newArray, 0, start);
        System.arraycopy(items, 0, newArray, start, items.length);
        System.arraycopy(source, start, newArray, start + items.length, newArray.length - start - items.length);

        System.out.println(Arrays.toString(newArray));

        return newArray;

    }

    public static int[]removeAll(int[] source, int start, int end){
        int [] newArray=new int[source.length-(end-start)];

        System.arraycopy(source,0,newArray,0,start);
        System.arraycopy(source,end,newArray,start,source.length-(end-start)-1);

        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static int[]fill(int[]source, int start, int end, int item){
        int [] newArray=new int[source.length+(end-start)];

        System.arraycopy(source,0,newArray,0,start);
        for (int i=start; i<end; i++){
            newArray[i]=item;
        }
        System.arraycopy(source,start,newArray,end, newArray.length-start-end+1);

        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static int []subArray(int[]source,int start, int end){
        int [] newArray=new int[end-start+1];

        System.arraycopy(source,start,newArray ,0,end-start+1);
        System.out.println(Arrays.toString(newArray));
        return newArray;

    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 3};
        int b = 2;
        int[] c = {33, 44, 55, 66};
        append(a, b);
        String s = "alma";
        System.out.println(s);
        String newString = s.toUpperCase();
        System.out.println(s);
        System.out.println(newString);
        System.out.println("contains:");
        System.out.println(contains(a, 4));
        System.out.println("find:");
        System.out.println(find(a, 4));
        System.out.println("insert:");
        insert(a, 2, 100);
        System.out.println("insertTogether:");
        insertTogether(a, 2, 100);
        System.out.println("insertAll:");
        insertAll(a, 0, c);
        System.out.println("removeAll:");
        removeAll(a,1,2);
        System.out.println("fill:");
        fill(a,1,3,20);
        System.out.println("subArray:");
        subArray(a,1,3);


        int[]napokSzama={31,28,31,30};
        int[][] t=new int[12][];
        for (int i=0; i<napokSzama.length; i++){
           t[i]=new int[napokSzama[i]];
        }

    }

}
