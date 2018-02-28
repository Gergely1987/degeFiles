package springboot.persistence;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
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

    public void save(Location location){
        jdbcTemplate.update("insert into locations(name, lat, lon) values (?, ?, ?)",
            location.getName(), location.getLat(),location.getLon());
    }

    public List<Location>listLocations(){
       return jdbcTemplate.query("select id, name, lat, lon from locations",
                new RowMapper<Location>() {
                    @Override
                    public Location mapRow(ResultSet resultSet, int i) throws SQLException { //nem kell ciklus, a spring megcsinálja helyettünk
                        return new Location(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("lat"),
                                resultSet.getDouble("lon"));
                    }
                });
    }
}
