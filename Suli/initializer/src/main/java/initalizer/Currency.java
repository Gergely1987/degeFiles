package initalizer;

public enum Currency {
    HUF(1), EUR(308.23), SFR(289.24), GBP(362.23), USD(289.77);

    double value;

    public double getValue() {
        return value;
    }

    Currency(double value) {
        this.value = value;
    }
}
