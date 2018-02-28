package methodchain.trainer;

public class TrainerBuilder {
    private String name;
    private int age;

    public TrainerBuilder giveName(String name){
        this.name=name;
        return this;
    }

    public TrainerBuilder giveAge(int age){
        this.age=age;
        return this;
    }

    public Trainer build(){
        return new Trainer(name,age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Trainer trainer=new TrainerBuilder().giveName("alma").giveAge(30).build();

    public static void main(String[] args) {
        Trainer trainer=new TrainerBuilder().giveAge(20).giveName("alma").build();
        System.out.println(trainer.getName());
        System.out.println(trainer.getAge());
        Trainer ts=new Trainer("k",20);
    }
}
