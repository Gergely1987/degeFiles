package dpintro.iteratorpattern;

import java.util.List;

public class ZooIterator implements Iterator {
  private int index;
  private List<Animal> animalList;

    public ZooIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return (index + 1 != animalList.size());
    }

    @Override
    public Object next() {
        if (hasNext()) {
            index++;
            return (animalList.get(index));
        }
        return null;
    }

}

