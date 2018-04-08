package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.LocationDao;
import restaurantrater.Models.Location;


import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Location findByName(String name){
        String sql = "SELECT * FROM Location WHERE name = ?";
        Location location = (Location) jdbcTemplate.queryForObject(
                sql, new Object[] { name },
                new BeanPropertyRowMapper(Location.class));
        return location;
    }

    public boolean checkName(String name) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Location WHERE name = ?", Integer.class, name);
        return count != null && count > 0;
    }

    public List<Location> findAll(){
        String sql = "SELECT * FROM Location";
        List<Location> locations  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Location.class));
        return locations;
    }

    public boolean checkPassword(String name, String password) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Location WHERE name = ? AND password = ?", Integer.class, new Object[] {name, password});
        return count != null && count > 0;
    }

    public int getHighestUserId() {
        String sql = "SELECT MAX(UserID) FROM Location";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List managerDateLocation(String type) {
        String sql = "SELECT L.manager_name, L.first_open_date FROM Restaurant AS R, Location AS L WHERE R.RestaurantID = L.RestaurantID AND R.Type = ?";
        Object[] params = {type};
        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }
}
