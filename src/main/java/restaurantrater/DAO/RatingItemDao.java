package restaurantrater.DAO;


import restaurantrater.Models.MenuItem;
import restaurantrater.Models.RatingItem;

import java.util.List;

public interface RatingItemDao {
    public List<RatingItem> findAll();
        public List<RatingItem> findRatingItemsByMenuItemId(int ItemId);
    public RatingItem insert(RatingItem ratingItem) ;

}