package collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {


    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String>newSet=new HashSet<>(stringCollection);
        return newSet;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
        Set<String>newSet=new HashSet<>(setA);
        newSet.add(setB.toString());
        return newSet;
    }

}
