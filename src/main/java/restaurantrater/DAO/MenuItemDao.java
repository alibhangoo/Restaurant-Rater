package restaurantrater.DAO;


import restaurantrater.Models.MenuItem;

import java.util.List;

public interface MenuItemDao {
    public List<MenuItem> findAll();
    public MenuItem findMenuItemById(int MenuItemID);
    public MenuItem findByName(String name);
    public List<MenuItem> findMenuItemsByRestaurantId(int RestaurantId);
    public int getHighestMenuItemId();
    public boolean checkName(String name);
    public MenuItem delete(MenuItem menuItem);
    public MenuItem insert(MenuItem menuItem);
    }
