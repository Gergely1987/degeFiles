package finalmodifier;

public class Gentlemen {


    public static String MESSAGE_PREFIX="szevasz tavasz ";

    public String sayHEllo(String name){
        String a=MESSAGE_PREFIX+name;
        return a;
    }

    public static void main(String[] args) {
       Gentlemen g=new Gentlemen();
        System.out.println(g.sayHEllo("Józsi"));
    }
}
