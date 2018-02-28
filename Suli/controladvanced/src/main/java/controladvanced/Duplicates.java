package controladvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    newList.add(list.get(i));
                    break;
                }
            }
        }

        return newList;
    }
}
