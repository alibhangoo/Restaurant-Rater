package restaurantrater.Models;


import java.sql.Date;

public class RatingItem {
    private int UserID;
    private int ItemID;
    private Date Date;
    private int rating;
    private String comment;

    public RatingItem() {

    }

    public RatingItem(int userID, int itemID, java.sql.Date date, int rating, String comment) {
        UserID = userID;
        ItemID = itemID;
        Date = date;
        this.rating = rating;
        this.comment = comment;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}