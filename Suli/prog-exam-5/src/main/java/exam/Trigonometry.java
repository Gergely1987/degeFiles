package exam;

public class Trigonometry {

    public double calculateA(int cLength, int aDegree) {
        if (isItToSmall(cLength) || isItToSmall(aDegree)) {
            throw new IllegalArgumentException();
        }

        double radian = aDegree * Math.PI / 180;
        double result = Math.sin(radian) / cLength * 100;
        return result;
    }

    public double calculateB(int cLength, int bDegree) {
        if (isItToSmall(cLength) || isItToSmall(bDegree)) {
            throw new IllegalArgumentException();
        }

        double radian = (90 - bDegree) * Math.PI / 180;
        double result = Math.sin(radian) / cLength * 100;
        return result;
    }


    private boolean isItToSmall(int a) {
        if (a <= 0) {
            return true;
        }
        return false;
    }


}
