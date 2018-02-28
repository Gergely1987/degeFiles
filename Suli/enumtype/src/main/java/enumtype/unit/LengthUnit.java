package enumtype.unit;

public enum LengthUnit {
    MILIMETER(false,1), CENTIMETER(false,10), METER(true,1000), YARD(false,914.4), FOOT(false,304.8), INCH(false,25.4);

    private final boolean si;
    private final double mil;

    LengthUnit(boolean si, double mil) {
        this.si = si;
        this.mil=mil;

    }

    public double getMil() {
        return mil;
    }

    public boolean isSi() {
        return si;
    }
}
