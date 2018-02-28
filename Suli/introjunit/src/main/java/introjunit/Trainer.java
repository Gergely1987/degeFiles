package introjunit;

public class Trainer {
    private String name;

    public Trainer (String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getUppercase(){
        return name.toUpperCase();
    }

    public static void main(String[] args) {

    }
}
