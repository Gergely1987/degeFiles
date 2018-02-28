package springboot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.businesslogic.Location;
import springboot.businesslogic.LocationService;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/api/locations", method = RequestMethod.POST)
    public String save(@RequestBody Location location){ //a beérkező JSON-t át kell alakítania location-ná
        locationService.save(location);
        return "{\"status\":\"OK\"}";
    }

    @RequestMapping(value = "/api/locations", method = RequestMethod.GET)
    public List<Location>listLocations(){
        return locationService.listLocations();
    }

}
