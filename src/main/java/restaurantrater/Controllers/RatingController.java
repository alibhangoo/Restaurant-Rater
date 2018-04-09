package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.*;
import restaurantrater.Models.Rater;
import restaurantrater.Models.Rating;
import restaurantrater.Models.RatingItem;
import restaurantrater.Models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RatingController {

    @Autowired
    private RaterDao raterDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private RatingDao ratingDao;

    @RequestMapping(value = {"/rating"}, method = RequestMethod.GET)
    public Map<String, Object> restaurantRating(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("restaurant") != null && allRequestParams.get("restaurant").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("restaurant"));

            List result = ratingDao.findRatingsByRestaurantId(id);
            map.put("ratings",result);
            map.put("status","success");
        }
        else if (allRequestParams.size() == 0) {
            List<Rating> ratings = ratingDao.findAll();
            map.put("rating", ratings);
            map.put("status", "success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value="/rating/add", method = RequestMethod.POST)
    public Map<String, Object> addRating(@RequestBody Rating rating) {
        HashMap<String, Object> map = new HashMap<>();

        Rating response = ratingDao.insert(rating);

        map.put("status", "success");
        map.put("rating",response);

        return map;
    }

}
