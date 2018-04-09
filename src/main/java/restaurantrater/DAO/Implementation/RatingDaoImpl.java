package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.RatingDao;
import restaurantrater.DAO.RatingItemDao;
import restaurantrater.Models.Rating;
import restaurantrater.Models.RatingItem;

import java.util.List;


@Repository
public class RatingDaoImpl implements RatingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rating> findAll() {
        String sql = "SELECT * FROM Rating";
        List<Rating> ratings= jdbcTemplate.query(sql, new BeanPropertyRowMapper<Rating>(Rating.class));
        return ratings;
    }

    public List<Rating> findRatingsByRestaurantId(int RestaurantId){
        String sql = "SELECT * FROM Rating WHERE RestaurantID = ?";
        Object[] params = {RestaurantId};
        List<Rating> ratings = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<Rating>(Rating.class));
        return ratings;
    }

    public Rating insert(Rating rating) {
        String sql = "INSERT INTO Rating " + "VALUES (?,?,?,?,?,?,?,?)";
        Object[] params = {rating.getUserID(), rating.getDate(), rating.getPrice(), rating.getFood(),rating.getMood(),rating.getStaff(), rating.getComments(), rating.getRestaurantID()};
        jdbcTemplate.update(sql, params);
        return rating;
    }


}
