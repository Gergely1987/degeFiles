package methodargvars.trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<Course> courses =new ArrayList<>();

    public void addCours(String name){
        courses.add(new Course(name));
    }

    public void addCourses(String s1, String... names){
        for (String name:names) {
            courses.add(new Course(name));
        }
    }

    public Trainer(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
