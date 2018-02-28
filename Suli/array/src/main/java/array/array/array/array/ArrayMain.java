package array.array.array.array;

public class ArrayMain {


    public static void main(String[] args) {
        String [] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println(week.length);

        int [] array=new int [5];
        array[0]=2;
        for (int i=1; i<array.length; i++){
          array[i]=  array[i-1]*2;
        }

        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]);

        }
        System.out.println();

        boolean [] trueFalse=new boolean[6];
        trueFalse[0]=false;
        for (int i=0; i<trueFalse.length-1; i++){
            if(trueFalse[i]==false){
                trueFalse[i+1]=true;
            } else{
                trueFalse[i+1]=false;
            }
        }
        for (int i=0; i<trueFalse.length; i++){
            System.out.println(trueFalse[i]);
        }




    }
}
