package genericmethod;

public class ArrayMiddleObjectFinder {

    public <T> T findMiddleObject (T... values) throws IllegalArgumentException{
        if(values==null){
            throw new NullPointerException();
        }
        if(values.length==0){
            throw new IllegalArgumentException();
        }
        if(values.length%2==0){
            throw new IllegalArgumentException("Even number of elements");
        }

        return values[values.length/2];
    }

    public static void main(String[] args) {
        int a=11;
        int b=2;
        int c=a/b;
        System.out.println(c);
    }
}
