package satellite;

public class CelestialCoordinates {
    private final int a;
    private final int b;
    private final int c;

    public CelestialCoordinates(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "CelestialCoordinates: x=" +a+", y="+b+", z="+c;

    }
}
