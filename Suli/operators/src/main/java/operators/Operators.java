package operators;

public class Operators {

    public boolean isEven(int n){
         boolean a=false;
            if(n%2==0){
                a=true;
            }
        System.out.println(a);
            return a;
    }

    private int b=0b01010101010101010101010101010101;


    public int flipEvenBits(int i){

        return i^b;

    }

}
