package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List<Object>items=new ArrayList<>();
    private int index;

    public SimpleBag(){
    }
    public void putItem(Object item){
        items.add(item);
    }
    public boolean isEmpty(){
        return items.size()==0;
    }
    public int size(){
        return items.size();
    }
    public void beforeFirst() {
        index = -1;
    }

    public boolean hasNext() {
        return (index < items.size() - 1);
    }

    public Object next() {
        index++;
        return items.get(index);
    }

    public boolean contains(Object item) {
        return items.contains(item);
    }

    public int getCursor() {
        return index;
    }


}
