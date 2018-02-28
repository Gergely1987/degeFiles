package satellite;

public class Satellite {
    private  CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(String.valueOf(destinationCoordinates.getA())) || isEmpty(String.valueOf(destinationCoordinates.getB())) || isEmpty(String.valueOf(destinationCoordinates.getC())) || isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        int aNew = destinationCoordinates.getA()+diff.getA();
        int bNew =  destinationCoordinates.getB()+diff.getB();
        int cNew =  destinationCoordinates.getC()+diff.getC();

        this.destinationCoordinates=new CelestialCoordinates(aNew,bNew,cNew);
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates.toString();

    }

    public boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
