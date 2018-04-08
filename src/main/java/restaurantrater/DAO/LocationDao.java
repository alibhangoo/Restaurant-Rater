package restaurantrater.DAO;


import restaurantrater.Models.Location;

import java.util.List;

public interface LocationDao {
    public List<Location> findAll();
    public List managerDateLocation(String type);
}
