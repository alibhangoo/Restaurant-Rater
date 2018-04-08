package restaurantrater.Controllers;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.RaterDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private RestaurantDao restaurantDao;
    /*
    @GetMapping("*")
    public String index() {
        return "index";
    }
    */

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public Map<String, Object> searchRestaurant(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("query") != null) {
            List<Restaurant> restaurants = restaurantDao.findAll();
            List<String> restaurantNames = new ArrayList<>();

            for (int i=0; i<restaurants.size(); i++) {
                restaurantNames.add(restaurants.get(i).getName());
            }

            List<ExtractedResult> searchResult = FuzzySearch.extractAll(allRequestParams.get("query"), restaurantNames, 60);

            List<Restaurant> result = new ArrayList<>();
            for (int i=0; i < searchResult.size(); i++) {
                String name = searchResult.get(i).getString();
                Restaurant r = restaurantDao.findByName(name);
                result.add(r);
            }

            map.put("result",result);
            map.put("status","success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }



}
