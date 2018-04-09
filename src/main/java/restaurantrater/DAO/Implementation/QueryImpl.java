package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.LocationDao;
import restaurantrater.Models.Location;
import restaurantrater.Models.Rater;
import restaurantrater.Models.Restaurant;

import java.util.List;

@Repository
public class QueryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List findRestaurant(int rid) {
        String sql = "SELECT * FROM Restaurant AS R, Location AS L WHERE (R.RestaurantID = ? AND R.RestaurantID = L.RestaurantID)";
        Object[] params = {rid};
        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List mostExpensive(String restaurantName) {
        String sql = "SELECT DISTINCT M.name, L.manager_name, L.hour_open, R.URL\n" +
                "FROM Location AS L, Restaurant AS R, MenuItem AS M\n" +
                "WHERE (L.RestaurantID = R.RestaurantID) AND (M.RestaurantID = R.RestaurantID)  AND M.Price IN(\n" +
                "\tSELECT DISTINCT MAX(M2.price)\n" +
                "\tFROM MenuItem as M2, Restaurant as R2\n" +
                "\tWHERE (M2.RestaurantID = R2.RestaurantID) AND (R2.name = ?)) AND (R.name = ?);";

        Object[] params = {restaurantName,restaurantName};
        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List averagePrices() {
        String sql = "SELECT R.Type, M.category, AVG(M.price) AS avgPriceCat \n" +
                "FROM MenuItem AS M, Restaurant as R \n" +
                "WHERE M.RestaurantID IN\n" +
                "\t(SELECT R2.RestaurantID FROM Restaurant As R2 WHERE R.type = R2.type) AND M.RestaurantID = R.RestaurantID\n" +
                "GROUP BY M.Category, R.Type ORDER BY R.type, M.Category;";

        List results = jdbcTemplate.queryForList(sql);
        return results;
    }

    public List queryF() {
        String sql = "SELECT R.name as restaurantName ,Rater.name, Rating.price, Rating.food, Rating.mood, Rating.staff\n" +
                "FROM Restaurant AS R, Rater, Rating \n" +
                "WHERE (Rater.userid = Rating.userid and Rating.restaurantid = R.restaurantid)\n" +
                "GROUP BY R.name ,Rater.userId, Rating.price, Rating.food, Rating.mood, Rating.staff ORDER BY R.name, Rater.name;";

        List results = jdbcTemplate.queryForList(sql);
        return results;
    }

    public List queryG() {
        String sql = "SELECT DISTINCT R.name, L.phone_number, R.type \n" +
                "FROM Restaurant AS R, Location AS L, Rating \n" +
                "WHERE R.restaurantid = L.restaurantid AND\n" +
                "\tNOT EXISTS (SELECT Ratings.date \n" +
                "\t\t\t\tFROM Rating AS Ratings \n" +
                "\t\t\t\tWHERE date_part('year', rating.date) =2015 AND date_part('month', rating.date) = 01);";

        List results = jdbcTemplate.queryForList(sql);
        return results;
    }

    public List queryH(int userId) {
        String sql = "SELECT DISTINCT R.name, L.first_open_date \n" +
                "FROM Restaurant as R, Location as L, Rating \n" +
                "WHERE  R.restaurantid = L.restaurantid AND Rating.restaurantid = R.restaurantid AND (rating.staff <\n" +
                "\t--(SELECT MAX(Xratings.price) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = 14 )\n" +
                "\t(SELECT MAX(Xratings.food) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = ?)\n" +
                "\tOR rating.staff < (SELECT MAX(Xratings.staff) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = ?)\n" +
                "\tOR rating.staff <\t(SELECT MAX(Xratings.mood) FROM Rater AS X ,Rating as Xratings WHERE Xratings.userid = X.userid AND X.userid = ? ))";


        Object[] params = {userId, userId, userId};

        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List queryI(String type) {
        String sql = "SELECT R.name as restaurantName, Rater.name --Type\n" +
                "FROM Restaurant AS R, Rater, Rating\n" +
                "WHERE R.Type = ? AND Rater.userid = Rating.userid AND Rating.restaurantid = R.restaurantid AND Rating.food IN\n" +
                "\t(SELECT DISTINCT MAX(Rating.food) FROM Rating, Restaurant as R2 WHERE R2.type = ?\n" +
                "\t);";


        Object[] params = {type,type};

        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List queryJ(String type) {
        String sql = "SELECT(case WHEN exists \n" +
                "\t   \t(SELECT COUNT(Rate) \n" +
                "\t\tFROM Restaurant as R, Rating as Rate \n" +
                "\t\tWHERE R.type = ? \n" +
                "\t\tAND R.restaurantid = rate.restaurantid HAVING COUNT(*)> ANY(\n" +
                "\t\t\tSELECT COUNT(Rating)\n" +
                "\t\t\tFROM Restaurant AS R, Rating \n" +
                "\t\t\tWHERE R.restaurantid = Rating.restaurantid \n" +
                "\t\t\tGROUP BY R.type)\n" +
                "\t\t) \n" +
                "then 1 \n" +
                "else 0 end);\n";


        Object[] params = {type};

        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List queryK() {
        String sql = "SELECT RT.Name, RT.join_date, RT.reputation, R.Name as restaurantName, RG.Date\n" +
                "FROM Rater AS RT, Restaurant AS R, Rating AS RG\n" +
                "WHERE RT.UserId IN\n" +
                "(SELECT RT1.UserId\n" +
                " FROM Rater AS RT1 GROUP BY RT1.UserId HAVING\n" +
                "\t\t(SELECT AVG(RG1.Mood + RG1.Food)\n" +
                "\t\tFROM Rating AS RG1\n" +
                "\t\tWHERE RG1.UserId = RT1.UserId) >= ALL(\n" +
                "\t\tSELECT AVG(RG2.mood + RG2.food)\n" +
                "\t\tFROM Rating AS RG2, Rater AS RT2\n" +
                "\t\tWHERE RG2.UserId = RT2.UserId GROUP BY RT2.UserId))\n" +
                "\t\tAND RG.UserId = RT.UserId AND RG.RestaurantID = R.RestaurantID;";

        List results = jdbcTemplate.queryForList(sql);
        return results;
    }

    public List queryL() {
        String sql = "SELECT RT.name, RT.join_date, RT.reputation, R.name as restaurantName, RG.Date \n" +
                "FROM Rater AS RT, Restaurant AS R, Rating AS RG \n" +
                "WHERE RT.UserId IN (SELECT RG1.UserId FROM Rater AS RG1 \n" +
                "\tWHERE\n" +
                "\t\t(SELECT AVG(mood) FROM Rating AS RT1 WHERE RT1.UserId = RG1.UserId)\n" +
                "\t\t\t>= ALL(SELECT AVG(mood) FROM Rating AS RT1 GROUP BY RT1.UserId)\n" +
                "\t\tOR (SELECT AVG(food) FROM Rating AS RT1 WHERE RT1.UserId = RG1.UserId)\n" +
                "\t\t\t>= ALL(SELECT AVG(food) FROM Rating AS RT1 GROUP BY RT1.UserId))\n" +
                "\t\tAND RG.UserId = RT.UserID AND RG.RestaurantID = R.RestaurantID;";

        List results = jdbcTemplate.queryForList(sql);
        return results;
    }

    public List queryM(Restaurant restaurant) {
        String sql = "SELECT DISTINCT Rater.name, Rater.reputation, Rating.comments as ratingComment, RatingItem.comment as ratingItemComment, MenuItem.name as menuItemName, MenuItem.price\n" +
                "FROM Rater, Rating, Restaurant, RatingItem, MenuItem\n" +
                "WHERE Rater.userid = Rating.userid \n" +
                "\tAND Restaurant.restaurantID = Rating.restaurantID\n" +
                "\tAND RatingItem.userid = Rater.userId\n" +
                "\tAND MenuItem.itemid = RatingItem.itemid\n" +
                "\tAND MenuItem.restaurantid = Restaurant.restaurantID\n" +
                "\tAND Restaurant.name = ?; --GROUP BY Rater.name, Rater.reputation HAVING COUNT(*) > 2;";


        Object[] params = {restaurant.getName()};

        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

    public List queryN(Rater rater) {
        String sql = "SELECT DISTINCT Rater.name, Rater.email\n" +
                "FROM Rater, Rating\n" +
                "WHERE Rater.userid = Rating.userid AND (Rating.price + Rating.food + Rating.mood + Rating.staff) < ANY(\n" +
                "SELECT (Rating.price + Rating.food + Rating.mood + Rating.staff) AS JohnRatings\n" +
                "FROM Rating, Rater \n" +
                "WHERE Rating.userid = Rater.userid AND Rater.name = ?);";


        Object[] params = {rater.getName()};

        List results = jdbcTemplate.queryForList(sql,params);
        return results;
    }

}