package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.Rater;
import restaurantrater.Models.Restaurant;

import java.util.List;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Restaurant> findAll() {
        String sql = "SELECT * FROM Restaurant";
        List<Restaurant> restaurants = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
        return restaurants;
    }

    public Restaurant findRestaurantById(int RestaurantID){
        String sql = "SELECT * FROM Restaurant WHERE RestaurantID = ?";
        Restaurant restaurant = (Restaurant) jdbcTemplate.queryForObject(
                sql, new Object[] { RestaurantID }, new BeanPropertyRowMapper(Restaurant.class));
        return restaurant;
    }

    public List<Restaurant> findRestaurantsByCategory(String type){
        String sql = "SELECT * FROM Restaurant WHERE Type = ?";
        Object[] params = {type};
        List<Restaurant> restaurants = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
        return restaurants;
    }

    public Restaurant insert(Restaurant restaurant) {
        String sql = "INSERT INTO Restaurant " + "VALUES (?,?,?,?)";
        Object[] params = {restaurant.getRestaurantId(), restaurant.getName(), restaurant.getType(), restaurant.getUrl()};
        jdbcTemplate.update(sql, params);
        return restaurant;
    }

    public boolean checkName(String name) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Restaurant WHERE Name = ?", Integer.class, name);
        return count != null && count > 0;
    }

    public int getHighestRestaurantId() {
        String sql = "SELECT MAX(RestaurantID) FROM Restaurant";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Restaurant findByName(String name){
        String sql = "SELECT * FROM Restaurant WHERE Name = ?";
        Restaurant restaurant = (Restaurant) jdbcTemplate.queryForObject(
                sql, new Object[] { name },
                new BeanPropertyRowMapper(Restaurant.class));
        return restaurant;
    }


    public Restaurant delete(Restaurant restaurant) {
        String sql = "DELETE FROM Restaurant WHERE RestaurantID = ?";
        Object[] params = {restaurant.getRestaurantId()};
        jdbcTemplate.update(sql, params);
        return restaurant;
    }
}
