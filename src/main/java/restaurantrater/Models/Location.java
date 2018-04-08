package restaurantrater.Models;

import java.sql.Date;

public class Location {

    private int LocationID;
    private Date first_open_date;
    private String manager_name;
    private String phone_number;
    private String street_address;
    private double hour_open;
    private double hour_close;
    private int RestaurantID;

    public Location(){
    }

    public Location(int locationID, Date first_open_date, String manager_name, String phone_number, String street_address, double hour_open, double hour_close, int restaurantID) {
        LocationID = locationID;
        this.first_open_date = first_open_date;
        this.manager_name = manager_name;
        this.phone_number = phone_number;
        this.street_address = street_address;
        this.hour_open = hour_open;
        this.hour_close = hour_close;
        RestaurantID = restaurantID;
    }

    public int getLocationID() {
        return LocationID;
    }

    public Date getFirst_open_date() {
        return first_open_date;
    }

    public String getManager_name() {
        return manager_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public double getHour_open() {
        return hour_open;
    }

    public double getHour_close() {
        return hour_close;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setLocationID(int locationID) {
        LocationID = locationID;
    }

    public void setFirst_open_date(Date first_open_date) {
        this.first_open_date = first_open_date;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setHour_open(double hour_open) {
        this.hour_open = hour_open;
    }

    public void setHour_close(double hour_close) {
        this.hour_close = hour_close;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }
}
