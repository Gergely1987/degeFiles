package Interfészek;

public class Bat implements Fly {
    @Override
    public void ascend() {
        System.out.println("emelkedek");
    }

    @Override
    public void descend(){
        System.out.println("süllyedek");
    }
}
