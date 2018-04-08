package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.LocationDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.Location;
import restaurantrater.Models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @GetMapping("/locations")
    public List<Location> location() {
        List<Location> locations = locationDao.findAll();
        return locations;
    }



}
