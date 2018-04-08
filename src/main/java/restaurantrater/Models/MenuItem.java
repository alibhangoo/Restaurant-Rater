package restaurantrater.Models;


import java.sql.Date;

public class MenuItem {
    private int ItemID;
    private String name;
    private String type;
    private String category;
    private String description;
    private double price;
    private int RestaurantID;
    public MenuItem(){
    }

    public MenuItem(int itemID, String name, String type, String category, String description, double price, int restaurantID) {
        ItemID = itemID;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        this.price = price;
        RestaurantID = restaurantID;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "ItemID=" + ItemID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", RestaurantID=" + RestaurantID +
                '}';
    }
}