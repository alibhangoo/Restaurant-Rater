package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.MenuItemDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.MenuItem;
import restaurantrater.Models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemDao menuItemDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @RequestMapping(value="/menuitem/add", method = RequestMethod.POST)
    public Map<String, Object> addMenuItem(@RequestBody MenuItem menuItem){
        HashMap<String, Object> map = new HashMap<>();
        int maxId = menuItemDao.getHighestMenuItemId();
        menuItem.setItemID(maxId + 1);

        MenuItem r = menuItemDao.insert(menuItem);
        map.put("status", "success");
        map.put("menuItem",r);

        return map;
    }

    @RequestMapping(value="/menuitem/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteMenuItem(@RequestBody String name){
        HashMap<String, Object> map = new HashMap<>();

        if (menuItemDao.checkName(name)) {
            MenuItem menuItem = menuItemDao.findByName(name);
            menuItemDao.delete(menuItem);
            map.put("status", "success");
            map.put("menuItem", menuItem);
        }
        else {
            map.put("status", "error");
            map.put("error","MenuItem does not exist");
        }

        return map;
    }

}
