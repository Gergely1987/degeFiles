package Interfészek;

public class Practice {
    public static void main(String[] args) {

        Bat denever=new Bat();
        process(denever);

    }

    public static void process(Fly animal){
        animal.ascend();
    }
}
