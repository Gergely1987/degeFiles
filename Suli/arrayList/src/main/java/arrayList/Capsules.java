package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> capsule =new ArrayList<>();

    public void addLast(String a){
        this.capsule.add(a);
    }

    public void addFirst(String a){
        this.capsule.add(0,a);
    }

    public void removeFirst(){
        this.capsule.remove(0);
    }

    public void removeLast(){
        this.capsule.remove(capsule.size()-1);

    }

    public List<String> getColors() {
        return capsule;
    }

    public String getColor() {
        return capsule.get(0);
    }

    public static void main(String[] args) {
        Capsules c=new Capsules();
        c.addFirst("fehér");
        c.addLast("kék");
        c.addFirst("zöld");

        System.out.println(c.getColors());
        System.out.println(c.getColor());

        List<String> cleanelni=c.getColors();
        System.out.println(cleanelni);
        cleanelni.clear();
        System.out.println(cleanelni);





    }


}
