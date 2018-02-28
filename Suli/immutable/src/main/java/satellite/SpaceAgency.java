package satellite;

import javax.swing.text.SimpleAttributeSet;
import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private final List<Satellite> newSatellites=new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if(isEmpty(satellite.toString())){
            throw new NullPointerException("Parameter must not be null!");
        }
        newSatellites.add(satellite);

    }


    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        Satellite sat=null;
        for (Satellite s: newSatellites) {
            if(!s.getRegisterIdent().equals(registerIdent)){
                throw new IllegalArgumentException("Satellite with the given registration cannot be found!");
            }
            sat=s;
        }



        return sat;

    }

    public boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
