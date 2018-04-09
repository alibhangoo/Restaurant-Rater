package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.RatingItemDao;
import restaurantrater.Models.MenuItem;
import restaurantrater.Models.RatingItem;

import java.util.List;


@Repository
public class RatingItemDaoImpl implements RatingItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RatingItem> findAll() {
        String sql = "SELECT * FROM RatingItem";
        List<RatingItem> ratingItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper<RatingItem>(RatingItem.class));
        return ratingItems;
    }

    public List<RatingItem> findRatingItemsByMenuItemId(int ItemId){
        String sql = "SELECT * FROM RatingItem WHERE ItemID = ?";
        Object[] params = {ItemId};
        List<RatingItem> ratingItems = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<RatingItem>(RatingItem.class));
        return ratingItems;
    }

    public RatingItem insert(RatingItem ratingItem) {
        String sql = "INSERT INTO RatingItem " + "VALUES (?,?,?,?,?)";
        Object[] params = {ratingItem.getUserID(),ratingItem.getItemID(),ratingItem.getDate(),ratingItem.getRating(),ratingItem.getComment()};
        jdbcTemplate.update(sql, params);
        return ratingItem;
    }
}
