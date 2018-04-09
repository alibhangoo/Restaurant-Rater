package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.MenuItemDao;
import restaurantrater.Models.MenuItem;

import java.util.List;


@Repository
public class MenuItemDaoImpl implements MenuItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MenuItem> findAll() {
        String sql = "SELECT * FROM MenuItem";
        List<MenuItem> menuItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MenuItem>(MenuItem.class));
        return menuItems;
    }

    public MenuItem findMenuItemById(int MenuItemID){
        String sql = "SELECT * FROM MenuItem WHERE MenuItemID = ?";
        MenuItem menuItem = (MenuItem) jdbcTemplate.queryForObject(
                sql, new Object[] { MenuItemID }, new BeanPropertyRowMapper(MenuItem.class));
        return menuItem;
    }

    public MenuItem findByName(String name){
        String sql = "SELECT * FROM MenuItem WHERE name = ?";
        MenuItem menuItem = (MenuItem) jdbcTemplate.queryForObject(
                sql, new Object[] { name },
                new BeanPropertyRowMapper(MenuItem.class));
        return menuItem;
    }

    public List<MenuItem> findMenuItemsByRestaurantId(int RestaurantId){
        String sql = "SELECT * FROM MenuItem WHERE RestaurantID = ?";
        Object[] params = {RestaurantId};
        List<MenuItem> menuItems = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<MenuItem>(MenuItem.class));
        return menuItems;
    }

    public int getHighestMenuItemId() {
        String sql = "SELECT MAX(ItemID) FROM MenuItem";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public boolean checkName(String name) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM MenuItem WHERE name = ?", Integer.class, name);
        return count != null && count > 0;
    }

    public MenuItem insert(MenuItem menuItem) {
        String sql = "INSERT INTO MenuItem " + "VALUES (?,?,?,?,?,?,?)";
        Object[] params = {menuItem.getItemID(), menuItem.getName(), menuItem.getType(), menuItem.getCategory(), menuItem.getDescription(), menuItem.getPrice(), menuItem.getRestaurantID()};
        jdbcTemplate.update(sql, params);
        return menuItem;
    }

    public MenuItem delete(MenuItem menuItem) {
        String sql = "DELETE FROM MenuItem WHERE ItemID = ?";
        Object[] params = {menuItem.getItemID()};
        jdbcTemplate.update(sql, params);
        return menuItem;
    }

}
