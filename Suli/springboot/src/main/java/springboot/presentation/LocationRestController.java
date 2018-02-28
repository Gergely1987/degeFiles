package springboot.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springboot.businesslogic.CreateLocationCommand;
import springboot.businesslogic.Location;
import springboot.businesslogic.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationRestController {

    private final LocationService locationService;

    @Autowired
    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public List<Location> listLocations() {
        return locationService.listLocations();
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    public String saveLocation(
            @RequestBody CreateLocationCommand createLocationCommand) {
        locationService.createLocation(createLocationCommand);
        return "{\"status\": \"ok\"}";
    }
}
