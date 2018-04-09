package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.RaterDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.Rater;
import restaurantrater.Models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantDao restaurantDao;

    @GetMapping("/restaurants")
    public List<Restaurant> restaurant() {
        List<Restaurant> restaurant = restaurantDao.findAll();
        return restaurant;
    }

    @RequestMapping(value = {"/restaurantCategories"}, method = RequestMethod.GET)
    public List restaurantCategories(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = restaurantDao.findCategories();

        return results;
    }

    @RequestMapping(value="/restaurant/add", method = RequestMethod.POST)
    public Map<String, Object> addRestaurant(@RequestBody Restaurant restaurant){
        HashMap<String, Object> map = new HashMap<>();
        int maxId = restaurantDao.getHighestRestaurantId();
        restaurant.setRestaurantId(maxId + 1);

        Restaurant r = restaurantDao.insert(restaurant);
        map.put("status", "success");
        map.put("restaurant",r);

        return map;
    }

    @RequestMapping(value="/restaurant/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteRestaurant(@RequestBody String name){
        HashMap<String, Object> map = new HashMap<>();

        if (restaurantDao.checkName(name)) {
            Restaurant restaurant = restaurantDao.findByName(name);
            restaurantDao.delete(restaurant);
            map.put("status", "success");
            map.put("restaurant", restaurant);
        }
        else {
            map.put("status", "error");
            map.put("error","Restaurant does not exist");
        }

        return map;
    }



}
