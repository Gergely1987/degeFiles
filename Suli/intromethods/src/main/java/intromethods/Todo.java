package intromethods;

public class Todo {
    private String caption;
    private boolean finished;

    @Override
    public String toString() {
        return "Todo{" +
                "caption=" + caption +
                ", finished=" + finished +
                '}';
    }

    public Todo() {
    }

    public void finish(){
        finished=true;
    }

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public static void main(String[] args) {
        Todo to=new Todo("takarítani");
        System.out.println(to);
    }
}
