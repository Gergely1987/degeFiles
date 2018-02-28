package records;

public class Subject {
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public boolean equals (Object ob){
        if(ob.equals(subjectName)){
            return true;
        }
        return false;
    }
}
