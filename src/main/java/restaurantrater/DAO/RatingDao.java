package restaurantrater.DAO;

import restaurantrater.Models.Rating;
import restaurantrater.Models.RatingItem;

import java.util.List;

public interface RatingDao {
    public List<Rating> findAll();
    public List<Rating> findRatingsByRestaurantId(int ItemId);
    public Rating insert(Rating rating);

}
