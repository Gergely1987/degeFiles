package genericclass;

public class DataPair<T> {

    private T[] arr= (T[]) new Object[2];

    public T[] getArr() {
        return arr;
    }

    public DataPair(T[] arr) {
        this.arr[0] = arr[0];

        if(arr.length==1){
            this.arr[1]=arr[0];
        }
        else{
           this.arr[1]=arr[arr.length-1];
        }
    }

    public T getFirstObject(){
        return arr[0];
    }
    public T getSecondObject(){
return arr[1];
    }

}
