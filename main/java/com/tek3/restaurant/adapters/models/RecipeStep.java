package com.tek3.restaurant.adapters.models;

import java.io.Serializable;

/**
 * Created by gaby on 4/18/15.
 */
public class RecipeStep implements Serializable {
    private String recipeStepNumber;
    private String recipeStepDescription;
    private String recipeStepImageURL;

    public RecipeStep() {}

    public String getRecipeStepNumber() {
        return recipeStepNumber;
    }

    public void setRecipeStepNumber(String recipeStepNumber) {
        this.recipeStepNumber = recipeStepNumber;
    }

    public String getRecipeStepDescription() {
        return recipeStepDescription;
    }

    public void setRecipeStepDescription(String recipeStepDescription) {
        this.recipeStepDescription = recipeStepDescription;
    }

    public String getRecipeStepImageURL() {
        return recipeStepImageURL;
    }

    public void setRecipeStepImageURL(String recipeStepImageURL) {
        this.recipeStepImageURL = recipeStepImageURL;
    }
}
