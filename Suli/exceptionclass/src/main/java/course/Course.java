package course;

public class Course {
    private String name;
    private SimpleTime begin;

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    public Course(String name, SimpleTime begin) {
        if(begin==null || name==null){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.begin = begin;
    }

    @Override
    public String toString() {
        return begin+": "+name;
    }
}
