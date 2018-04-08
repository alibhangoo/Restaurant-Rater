package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.LocationDao;
import restaurantrater.Models.Location;

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
                "\tWHERE (M2.RestaurantID = R2.RestaurantID) AND (R2.name = 'Popeyes')) AND (R.name = ?);";

        Object[] params = {restaurantName};
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


}