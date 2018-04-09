package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.MenuItemDao;
import restaurantrater.DAO.RatingItemDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.MenuItem;
import restaurantrater.Models.RatingItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RatingItemController {

    @Autowired
    private MenuItemDao menuItemDao;

    @Autowired
    private RatingItemDao ratingItemDao;

    @RequestMapping(value = {"/ratingitems"}, method = RequestMethod.GET)
    public Map<String, Object> queryD(@RequestParam Map<String,String> allRequestParams) {
        HashMap<String, Object> map = new HashMap<>();
        if (allRequestParams.size() == 1 && allRequestParams.get("menuitem") != null && allRequestParams.get("menuitem").matches("[-+]?\\d*\\.?\\d+")) {
            int id = Integer.parseInt(allRequestParams.get("menuitem"));

            List result = ratingItemDao.findRatingItemsByMenuItemId(id);
            map.put("ratingItems",result);
            map.put("status","success");
        }
        else if (allRequestParams.size() == 0) {
            List<RatingItem> ratingItems = ratingItemDao.findAll();
            map.put("ratingItems", ratingItems);
            map.put("status", "success");
        }
        else {
            map.put("status", "error");
            map.put("error","Invalid parameters");
        }

        return map;
    }

    @RequestMapping(value="/ratingitem/add", method = RequestMethod.POST)
    public Map<String, Object> addRating(@RequestBody RatingItem ratingItem) {
        HashMap<String, Object> map = new HashMap<>();

        RatingItem response = ratingItemDao.insert(ratingItem);

        map.put("status", "success");
        map.put("rating",response);

        return map;
    }

}
