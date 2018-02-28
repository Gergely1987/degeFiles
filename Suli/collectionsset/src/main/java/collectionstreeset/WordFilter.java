package collectionstreeset;

import java.util.*;

public class WordFilter {


    public Set<String> filterWords(String[] randomStrings) {
        List<String> newList = Arrays.asList(randomStrings);
        Set<String> newSet = new TreeSet<>(newList);

        return newSet;
    }
}
