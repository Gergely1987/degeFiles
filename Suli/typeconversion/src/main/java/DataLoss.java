public class DataLoss {
    private void dataLoss() {
        int capacity = 0;
        float a;
        long b;

        for (long i = 0; i < Long.MAX_VALUE && capacity < 3; i++) {
            a = (float) i;
            b = (long) a;
            if (i != b) {
                System.out.println("Az eredeti szám: " + i);
                System.out.println("float konvertálás után: " + b);
                System.out.println("A különbség konvertálás után: " + Math.abs(i - b));
                int x = (int) i;
                System.out.println("Kettes számrendszerben: " + Integer.toBinaryString(x));
                capacity++;
            }
        }
    }


    public static void main(String[] args) {
        DataLoss dLoss = new DataLoss();

        dLoss.dataLoss();



    }
}

