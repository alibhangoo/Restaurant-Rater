package restaurantrater.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import restaurantrater.DAO.RaterDao;
import restaurantrater.Models.Rater;
import java.sql.*;
import java.util.List;

@Repository
public class RaterDaoImpl implements RaterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Rater findByName(String name){
        String sql = "SELECT * FROM Rater WHERE name = ?";
        Rater rater = (Rater) jdbcTemplate.queryForObject(
                sql, new Object[] { name },
                new BeanPropertyRowMapper(Rater.class));
        return rater;
    }

    public boolean checkName(String name) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Rater WHERE name = ?", Integer.class, name);
        return count != null && count > 0;
    }

    public Rater insert(Rater rater) {
        String sql = "INSERT INTO Rater " + "VALUES (?,?,?,?,?,?,?)";
        Object[] params = {rater.getUserID(), rater.getEmail(), rater.getName(), rater.getJoinDate(), rater.getType(), rater.getReputation(), rater.getPassword()};
        jdbcTemplate.update(sql, params);
        return rater;
    }

    public Rater delete(Rater rater) {
        String sql = "DELETE FROM Rater WHERE UserID = ?";
        Object[] params = {rater.getUserID()};
        jdbcTemplate.update(sql, params);
        return rater;
    }

    public List<Rater> findAll(){
        String sql = "SELECT * FROM Rater";
        List<Rater> raters  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Rater.class));
        return raters;
    }

    public boolean checkPassword(String name, String password) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Rater WHERE name = ? AND password = ?", Integer.class, new Object[] {name, password});
        return count != null && count > 0;
    }

    public int getHighestUserId() {
        String sql = "SELECT MAX(UserID) FROM Rater";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
