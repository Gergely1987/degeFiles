package springboot.businesslogic;

import org.springframework.stereotype.Service;
import springboot.persistence.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public List<Location>listLocations(){
        return locationRepository.listLocations();
    }
}
