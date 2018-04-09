package restaurantrater.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.Implementation.QueryImpl;
import restaurantrater.DAO.LocationDao;
import restaurantrater.DAO.MenuItemDao;
import restaurantrater.DAO.RaterDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.Location;
import restaurantrater.Models.MenuItem;
import restaurantrater.Models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QueryController {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private MenuItemDao menuItemDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private RaterDao raterDao;

    @Autowired
    private QueryImpl queryImpl;

    @RequestMapping(value = {"/restaurant"}, method = RequestMethod.GET)
    public Map<String, Object> queryA(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("id") != null && allRequestParams.get("id").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("id"));
            if (id > restaurantDao.getHighestRestaurantId()) {
                map.put("status", "error");
                map.put("error","ID does not exist");
            }
            else {
                List result = queryImpl.findRestaurant(id);
                map.put("result", result);
                map.put("status", "success");
            }
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }


    @RequestMapping(value = {"/menuitems"}, method = RequestMethod.GET)
    public Map<String, Object> queryB(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("restaurant") != null && allRequestParams.get("restaurant").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("restaurant"));

            List<MenuItem> menuItems = menuItemDao.findMenuItemsByRestaurantId(id);

            if (menuItems.size() == 0) {
                map.put("status", "error");
                map.put("error","Restaurant does not exist");
            }
            else {
                map.put("menuItems", menuItems);
                map.put("status", "success");
            }
        }
        else if (allRequestParams.size() == 0) {
            List<MenuItem> menuItems = menuItemDao.findAll();
            map.put("menuItems", menuItems);
            map.put("status", "success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/manager"}, method = RequestMethod.GET)
    public Map<String, Object> queryC(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("type") != null) {
            List result = locationDao.managerDateLocation(allRequestParams.get("type"));
            map.put("result",result);
            map.put("status","success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/expensiveItem"}, method = RequestMethod.GET)
    public Map<String, Object> queryD(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("restaurant") != null && allRequestParams.get("restaurant").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("restaurant"));
            Restaurant restaurant = restaurantDao.findRestaurantById(id);

            List result = queryImpl.mostExpensive(restaurant.getName());
            map.put("result",result);
            map.put("status","success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/averagePrices"}, method = RequestMethod.GET)
    public List queryE(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = queryImpl.averagePrices();

        return results;
    }

    @RequestMapping(value = {"/totalRatings"}, method = RequestMethod.GET)
    public List queryF(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = queryImpl.queryF();

        return results;
    }

    @RequestMapping(value = {"/notRatedJuly2015"}, method = RequestMethod.GET)
    public List queryG(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = queryImpl.queryG();

        return results;
    }

    @RequestMapping(value = {"/staffRatingLowerThan"}, method = RequestMethod.GET)
    public Map<String, Object> queryH(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("user") != null && allRequestParams.get("user").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("user"));

            List result = queryImpl.queryH(id);
            map.put("result",result);
            map.put("status","success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/highestFoodRating"}, method = RequestMethod.GET)
    public Map<String, Object> queryI(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("type") != null) {

            List result = queryImpl.queryI(allRequestParams.get("type"));
            map.put("result",result);
            map.put("status","success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/morePopular"}, method = RequestMethod.GET)
    public Map<String, Object> queryJ(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("type") != null) {

            List result = queryImpl.queryJ(allRequestParams.get("type"));
            map.put("result", result);
            map.put("status", "success");
        } else {
            map.put("status", "error");
            map.put("error", "Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/highestOverallRating1"}, method = RequestMethod.GET)
    public List queryK(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = queryImpl.queryK();

        return results;
    }

    @RequestMapping(value = {"/highestOverallRating2"}, method = RequestMethod.GET)
    public List queryL(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        List results = queryImpl.queryL();

        return results;
    }

    @RequestMapping(value = {"/mostFrequent"}, method = RequestMethod.GET)
    public Map<String, Object> queryM(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("restaurant") != null) {
            int id = Integer.parseInt(allRequestParams.get("restaurant"));

            List result = queryImpl.queryM(restaurantDao.findRestaurantById(id));
            map.put("result", result);
            map.put("status", "success");
        } else {
            map.put("status", "error");
            map.put("error", "Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value = {"/lowerThan"}, method = RequestMethod.GET)
    public Map<String, Object> queryN(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("user") != null) {
            int id = Integer.parseInt(allRequestParams.get("user"));

            List result = queryImpl.queryN(raterDao.findByUserId(id));
            map.put("result", result);
            map.put("status", "success");
        } else {
            map.put("status", "error");
            map.put("error", "Invalid parameters");
        }

        return map;
    }


}