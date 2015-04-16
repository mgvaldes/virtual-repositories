package com.tek3.restaurant.adapters.models;

/**
 * Created by root on 15/04/15.
 */
public class RestaurantCategory {
    private String restaurantCategoryName;
    private String restaurantCategoryImageURL;

    public RestaurantCategory() {}

    public RestaurantCategory(String restaurantCategoryName, String restaurantCategoryImageURL) {
        this.restaurantCategoryName = restaurantCategoryName;
        this.restaurantCategoryImageURL = restaurantCategoryImageURL;
    }

    public String getRestaurantCategoryName() {
        return restaurantCategoryName;
    }

    public void setRestaurantCategoryName(String restaurantCategoryName) {
        this.restaurantCategoryName = restaurantCategoryName;
    }

    public String getRestaurantCategoryImageURL() {
        return restaurantCategoryImageURL;
    }

    public void setRestaurantCategoryImageURL(String restaurantCategoryImageURL) {
        this.restaurantCategoryImageURL = restaurantCategoryImageURL;
    }
}
