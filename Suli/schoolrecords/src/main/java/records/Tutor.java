package records;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject>taughtSubject=new ArrayList<>();

    public boolean tutorTeachingSubject(Subject subject){
       boolean isItTeached=false;
        for (int i = 0; i <taughtSubject.size() ; i++) {
            if(subject.getSubjectName().contains(taughtSubject.get(i).getSubjectName())){
                isItTeached= true;
                break;
            }
        }
        return isItTeached;
    }

    public String getName() {
        return name;
    }

    public Tutor(String name, List<Subject> taughtSubject) {
        this.name = name;
        this.taughtSubject = taughtSubject;
    }
}
