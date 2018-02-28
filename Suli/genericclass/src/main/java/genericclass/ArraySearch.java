package genericclass;

public class ArraySearch {

    public DataPair<String> getFirstAndLastWord(String[] words){

        if(words==null){
            throw new NullPointerException();
        }
        else if(words.length==0){
            throw new IllegalArgumentException();
        }
        else{
            return new DataPair<>(words);
        }
    }
}
