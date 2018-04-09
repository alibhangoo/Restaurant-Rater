package restaurantrater.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurantrater.DAO.RaterDao;
import restaurantrater.DAO.RestaurantDao;
import restaurantrater.Models.LoginUser;
import restaurantrater.Models.Rater;
import restaurantrater.Models.Restaurant;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RaterController {

    @Autowired
    private RaterDao raterDao;


    @GetMapping("/raters")
    public List<Rater> raters() {

        List<Rater> raters = raterDao.findAll();

        return raters;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> login(@RequestBody LoginUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        HashMap<String, String> map = new HashMap<>();

        if (!raterDao.checkName(username)) {
            map.put("status", "error");
            map.put("error","Username not found");
        }
        else if (!raterDao.checkPassword(username, password)) {
            map.put("status", "error");
            map.put("error","Password invalid");
        }
        else {
            Rater rater = raterDao.findByName(username);
            map.put("status", "success");
            map.put("username", username);
            map.put("userID", Integer.toString(rater.getUserID()));
        }

        return map;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Map<String, Object> saveUser(@RequestBody Rater user){
        HashMap<String, Object> map = new HashMap<>();
        int maxId = raterDao.getHighestUserId();
        user.setUserID(maxId + 1);
        if (raterDao.checkName(user.getName())) {
            map.put("status", "error");
            map.put("error", "Username taken");
        }
        else {
            Rater rater = raterDao.insert(user);
            map.put("status", "success");
            map.put("user",rater);
        }
        return map;
    }

    @RequestMapping(value="/user/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteUser(@RequestBody String username){
        HashMap<String, Object> map = new HashMap<>();
        if (raterDao.checkName(username)) {
            Rater rater = raterDao.findByName(username);
            raterDao.delete(rater);
            map.put("status", "success");
            map.put("user", rater);
        }
        else {
            map.put("status", "error");
            map.put("error","User does not exist");
        }

        return map;
    }



}
