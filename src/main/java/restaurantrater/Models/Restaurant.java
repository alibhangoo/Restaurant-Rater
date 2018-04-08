package restaurantrater.Models;

import java.util.Date;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String type;
    private String url;

    public Restaurant(){
    }

    public Restaurant(int restaurantId, String name, String type, String url) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}