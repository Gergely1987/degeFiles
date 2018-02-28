package exceptions.polinom;

public class Polynomial {
    private double[] polinom;


    public Polynomial(double[] polinom) {
        if (polinom == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.polinom = polinom;
    }

    public Polynomial(String[] poli) {
        if (poli == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] polinomsConverted = new double[poli.length];
        for (int i = 0; i <poli.length ; i++) {
           try {
               polinomsConverted[i] = Integer.parseInt(poli[i]);
           }
           catch (NumberFormatException nfe){
               throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
           }
        }
        this.polinom = polinomsConverted;
    }


    public double[] getCoefficients() {
        return polinom;
    }
    public double evaluate(double x) {
        double result = 0;

        for (int i = 0; i < polinom.length; i++) {
            result += Math.pow(x, polinom.length - (i + 1)) * polinom[i];
        }

        return result;
    }


}
