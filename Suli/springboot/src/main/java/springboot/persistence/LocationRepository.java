package springboot.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springboot.businesslogic.CreateLocationCommand;
import springboot.businesslogic.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> listLocations() {
        return jdbcTemplate.query("select id, name, lat, lon from locations", new RowMapper<Location>() {
            @Override
            public Location mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double lat = resultSet.getDouble("lat");
                double lon = resultSet.getDouble("lon");
                Location location = new Location(id, name, lat, lon);
                return location;
            }
        });
    }

    public void createLocation(CreateLocationCommand createLocationCommand) {
        jdbcTemplate.update("insert into locations(name, lat, lon) values (?, ?, ?)",
                createLocationCommand.getName(), createLocationCommand.getLat(), createLocationCommand.getLon());
    }
}
