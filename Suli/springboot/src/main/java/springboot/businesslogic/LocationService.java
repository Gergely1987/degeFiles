package springboot.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.persistence.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> listLocations() {
        return locationRepository.listLocations();
    }

    public void createLocation(CreateLocationCommand createLocationCommand) {
        locationRepository.createLocation(createLocationCommand);
    }
}
