package interfaces.trainer;

public class Trainer implements HasName,CanWork{

private String name;
private boolean working;
private boolean finished=true;

    public Trainer(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean work() {
        return working;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
