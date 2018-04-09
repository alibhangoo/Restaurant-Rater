package restaurantrater.DAO;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import restaurantrater.Models.Restaurant;

import java.util.List;

public interface RestaurantDao {

    //public void insert(Rater rater);
    //public Rater findByUserID(int UserID)
    public List<Restaurant> findAll();

    public Restaurant findRestaurantById(int RestaurantID);

    public Restaurant insert(Restaurant restaurant);

    public boolean checkName(String name);

    public int getHighestRestaurantId();

    public Restaurant findByName(String name);

    public Restaurant delete(Restaurant restaurant);

    public List findRestaurantsByCategory(String type);

    public List findCategories();
    }
