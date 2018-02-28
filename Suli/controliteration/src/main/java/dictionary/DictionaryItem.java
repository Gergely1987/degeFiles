package dictionary;

import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> words;

    public String getWord() {
        return word;
    }

    public List<String> getWords() {
        return words;
    }

    public DictionaryItem(String word, List<String> words) {
        this.word = word;
        this.words = words;
        addTranslations(words);
    }


    public void addTranslations(List<String>newTranslations){
        for (int i = 0; i <newTranslations.size(); i++) {
            if(!words.contains(newTranslations.get(i))){
               words.add(newTranslations.get(i));
            }
        }





    }
}
