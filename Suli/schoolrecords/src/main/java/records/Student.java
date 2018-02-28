package records;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Student {
    List<Mark> marks = new ArrayList<>();
    String name;


    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    private double round(double nuToRound, int placesToRound) {
        BigDecimal numToRoundBD = new BigDecimal(Double.toString(nuToRound));
        numToRoundBD = numToRoundBD.setScale(placesToRound, BigDecimal.ROUND_HALF_UP);
        double numToRoundToDouble = numToRoundBD.doubleValue();
        return numToRoundToDouble;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String toStr = "";
        for (int i = 0; i < marks.size(); i++) {
            toStr += name + " marks: " + marks.get(i).getSubject().getSubjectName() + ": " + marks.get(i).getMarkType().toString();
        }
        return toStr;
    }

    public double calculateAverage() {
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < marks.size(); i++) {
            sum += marks.get(i).getMarkType().getValue();
        }
        if (sum == 0) {
            avg = 0;
        } else {
            avg = sum / marks.size();
        }


        return round(avg, 2);

    }

    public double calculateSubjectAverage(Subject sub) {
        double sum = 0;
        double count = 0;
        double avg;
        for (int i = 0; i < marks.size(); i++) {
            if (sub.getSubjectName().equals(marks.get(i).getSubject().getSubjectName())) {
                sum += marks.get(i).getMarkType().getValue();
                count++;
            }
        }
        if (count == 0) {
            avg = 0.0;
        } else {
            avg = sum / count;
        }

        return round(avg, 2);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Student) {
            if (((Student) obj).getName().equals(this.getName())) {
                return true;
            }
        }
        return false;


    }


    public void grading(Mark mark) {
        if (isEmpty(mark)) {
            throw new NullPointerException("Mark must not be null!");
        }

        marks.add(mark);

    }

    private boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;

    }

    private boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;

    }

}
