package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {

    private List<Thermometer> roomsToHeat=new ArrayList<>();

    public void addThermometer(Thermometer thermometer){

    }

    public List<Thermometer>getRoomsToHeat(){
        return roomsToHeat;
    }
}
