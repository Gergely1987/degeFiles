package measuring;

public class Measurement {
    double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }


    public double[] getValues() {
        return values;
    }

    public int findFirstIndexInLimit(int lower, int upper){
        for (int i = 0; i < values.length; i++) {
            if(values[i]>lower && values[i]<upper){
                return i;
            }
        }
        return -1;
    }

    public double minimum(){
        double min=values[0];
        for (int i = 0; i <values.length; i++) {
            if(values[i]<min){
                min=values[i];
            }
        }
        return min;
    }

    public double maximum(){
        double max=values[0];
        for (int i = 0; i <values.length; i++) {
            if(values[i]>max){
                max=values[i];
            }
        }
        return max;
    }

    public ExtremValues minmax(){
        double min=values[0];
        double max=values[0];

        for (int i = 0; i <values.length ; i++) {
            if(values[i]<min){
                min=values[i];
            }
            if(values[i]>max) {
                max=values[i];
            }
        }
        ExtremValues ev=new ExtremValues(min,max);
    return ev;
    }

}
