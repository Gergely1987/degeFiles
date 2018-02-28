package constructoroverloading.trainer;

public class Trainer {

    private String name;
    private int age;

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Trainer(String name) {
        this.name = name;
        this.age=20;
    }

    public Trainer() {
        this.name="anonymous";
        this.age=20;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
