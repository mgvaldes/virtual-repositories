package com.tek3.restaurant.adapters.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaby on 4/18/15.
 */
public class Recipe implements Serializable {
    private String recipeName;
    private String recipePrice;
    private String restaurantName;
    private Integer recipeDifficulty;
    private Integer recipePreparationTime;
    private String recipeImageURL;
    private Boolean isBought;
    private Boolean isFavorite;
    private String recipeInstructions;
    private String recipeInstructionsYoutubeURL;
    private List<RecipeStep> recipeSteps;

    public Recipe() {
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(String recipePrice) {
        this.recipePrice = recipePrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getRecipeDifficulty() {
        return recipeDifficulty;
    }

    public void setRecipeDifficulty(Integer recipeDifficulty) {
        this.recipeDifficulty = recipeDifficulty;
    }

    public Integer getRecipePreparationTime() {
        return recipePreparationTime;
    }

    public void setRecipePreparationTime(Integer recipePreparationTime) {
        this.recipePreparationTime = recipePreparationTime;
    }

    public String getRecipeImageURL() {
        return recipeImageURL;
    }

    public void setRecipeImageURL(String recipeImageURL) {
        this.recipeImageURL = recipeImageURL;
    }

    public Boolean getIsBought() {
        return isBought;
    }

    public void setIsBought(Boolean isBought) {
        this.isBought = isBought;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeInstructionsYoutubeURL() {
        return recipeInstructionsYoutubeURL;
    }

    public void setRecipeInstructionsYoutubeURL(String recipeInstructionsYoutubeURL) {
        this.recipeInstructionsYoutubeURL = recipeInstructionsYoutubeURL;
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
