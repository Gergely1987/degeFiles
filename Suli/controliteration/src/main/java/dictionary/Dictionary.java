package dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private List<DictionaryItem>dictionaryItems=new ArrayList<>();

    public void addItem(String word, List<String>translations){

        if(!dictionaryItems.contains(word)){
           DictionaryItem a=new DictionaryItem(word,translations);
           dictionaryItems.add(a);
        }
    }

    public List<String>findTranslations(String word){
        List<String>newTrans=null;

        for (int i = 0; i <dictionaryItems.size(); i++) {
            if(dictionaryItems.get(i).equals(word)){
                newTrans.add(dictionaryItems.get(i).getWord());
            }
        }
        return  newTrans;
    }

    public static void main(String[] args) {
        Dictionary d=new Dictionary();
        d.addItem("csinál", Arrays.asList("do"));
        System.out.println(d);
    }

}
