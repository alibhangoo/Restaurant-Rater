package restaurantrater.Models;


import java.sql.Date;

public class Rater {
    private int UserID;
    private String name;
    private String email;
    private Date joinDate;
    private String type;
    private int reputation;
    private String password;

    public Rater(){
    }

    public Rater(int UserID, String email, String name, Date joinDate, String type, int reputation, String password)     {
        this.UserID = UserID;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.type = type;
        this.reputation = reputation;
        this.password = password;
    }

    public int getUserID() {
        return UserID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getType() {
        return type;
    }

    public int getReputation() {
        return reputation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "Rater{" +
                "UserID=" + UserID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", joinDate=" + joinDate +
                ", type='" + type + '\'' +
                ", reputation=" + reputation +
                ", password='" + password + '\'' +
                '}';
    }
}