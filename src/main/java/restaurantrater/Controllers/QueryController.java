package restaurantrater.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.Implementation.QueryImpl;
import restaurantrater.DAO.LocationDao;
import restaurantrater.DAO.MenuItemDao;
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




}