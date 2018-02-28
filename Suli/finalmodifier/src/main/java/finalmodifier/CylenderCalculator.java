package finalmodifier;

public class CylenderCalculator {

    public static double calculateVolume(double r, double h){
        double result=r*r*CircleCalculator.PI;
        return result;
    }

    public static double calculateSurfaceArea(double r, double h){
        double result=2*r*CircleCalculator.PI;
                return result;
    }


}
