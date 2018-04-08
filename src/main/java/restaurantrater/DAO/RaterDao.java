package restaurantrater.DAO;

import restaurantrater.Models.Rater;

import java.util.List;

public interface RaterDao {
    public Rater insert(Rater rater);
    public Rater findByName(String Username);
    public List<Rater> findAll();
    public boolean checkPassword(String username, String password);
    public boolean checkName(String username);
    public Rater delete(Rater rater);
    public int getHighestUserId();
}
