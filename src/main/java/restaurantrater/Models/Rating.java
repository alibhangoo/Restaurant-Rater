package restaurantrater.Models;


import java.sql.Date;

public class Rating {
    private int UserID;
    private Date Date;
    private int Price;
    private int Food;
    private int Mood;
    private int Staff;
    private String Comments;
    private int RestaurantID;

    public Rating() {

    }

    public Rating(int userID, java.sql.Date date, int price, int food, int mood, int staff, String comments, int restaurantID) {
        UserID = userID;
        Date = date;
        Price = price;
        Mood = mood;
        Staff = staff;
        Comments = comments;
        RestaurantID = restaurantID;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int food) {
        Food = food;
    }

    public int getUserID() {
        return UserID;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public int getPrice() {
        return Price;
    }

    public int getMood() {
        return Mood;
    }

    public int getStaff() {
        return Staff;
    }

    public String getComments() {
        return Comments;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setMood(int mood) {
        Mood = mood;
    }

    public void setStaff(int staff) {
        Staff = staff;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }
}