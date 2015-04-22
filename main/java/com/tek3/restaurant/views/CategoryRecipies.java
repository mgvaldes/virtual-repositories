package com.tek3.restaurant.views;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.CategoryRecipiesCustomArrayAdapter;
import com.tek3.restaurant.adapters.models.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaby on 4/18/15.
 */
public class CategoryRecipies extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_recipies);

        CategoryRecipiesCustomArrayAdapter adapter = new CategoryRecipiesCustomArrayAdapter(this, initStaticCategoryRecipies());

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        Recipe selectedRecipe = (Recipe) getListView().getItemAtPosition(position);

        Intent recipeDetailsActivity = new Intent(CategoryRecipies.this, RecipeDetails.class);

        recipeDetailsActivity.putExtra("recipe", selectedRecipe);

        CategoryRecipies.this.startActivity(recipeDetailsActivity);
    }

    public List<Recipe> initStaticCategoryRecipies() {
        ArrayList<Recipe> categoryRecipies = new ArrayList<Recipe>();
        Recipe categoryRecipe;

        categoryRecipe = new Recipe();
        categoryRecipe.setRecipeName("Receta 1");
        categoryRecipe.setRecipePrice("10$");
        categoryRecipe.setRestaurantName("Restaurant 1");
        categoryRecipe.setRecipeDifficulty(1);
        categoryRecipe.setRecipePreparationTime(10);
        categoryRecipe.setRecipeImageURL("http://mexico.cnn.com/media/2012/07/12/pato-comida-cocina-gastronoma.jpg");
        categoryRecipe.setIsBought(false);
        categoryRecipe.setIsFavorite(false);
        categoryRecipies.add(categoryRecipe);

        categoryRecipe = new Recipe();
        categoryRecipe.setRecipeName("Receta 2");
        categoryRecipe.setRecipePrice("20$");
        categoryRecipe.setRestaurantName("Restaurant 1");
        categoryRecipe.setRecipeDifficulty(2);
        categoryRecipe.setRecipePreparationTime(20);
        categoryRecipe.setRecipeImageURL("http://mexico.cnn.com/media/2012/07/12/pato-comida-cocina-gastronoma.jpg");
        categoryRecipe.setIsBought(true);
        categoryRecipe.setIsFavorite(false);
        categoryRecipies.add(categoryRecipe);

        categoryRecipe = new Recipe();
        categoryRecipe.setRecipeName("Receta 3");
        categoryRecipe.setRecipePrice("30$");
        categoryRecipe.setRestaurantName("Restaurant 1");
        categoryRecipe.setRecipeDifficulty(3);
        categoryRecipe.setRecipePreparationTime(30);
        categoryRecipe.setRecipeImageURL("http://mexico.cnn.com/media/2012/07/12/pato-comida-cocina-gastronoma.jpg");
        categoryRecipe.setIsBought(false);
        categoryRecipe.setIsFavorite(false);
        categoryRecipies.add(categoryRecipe);

        categoryRecipe = new Recipe();
        categoryRecipe.setRecipeName("Receta 4");
        categoryRecipe.setRecipePrice("10$");
        categoryRecipe.setRestaurantName("Restaurant 1");
        categoryRecipe.setRecipeDifficulty(1);
        categoryRecipe.setRecipePreparationTime(10);
        categoryRecipe.setRecipeImageURL("http://mexico.cnn.com/media/2012/07/12/pato-comida-cocina-gastronoma.jpg");
        categoryRecipe.setIsBought(false);
        categoryRecipe.setIsFavorite(false);
        categoryRecipies.add(categoryRecipe);

        categoryRecipe = new Recipe();
        categoryRecipe.setRecipeName("Receta 5");
        categoryRecipe.setRecipePrice("20$");
        categoryRecipe.setRestaurantName("Restaurant 1");
        categoryRecipe.setRecipeDifficulty(2);
        categoryRecipe.setRecipePreparationTime(20);
        categoryRecipe.setRecipeImageURL("http://mexico.cnn.com/media/2012/07/12/pato-comida-cocina-gastronoma.jpg");
        categoryRecipe.setIsBought(false);
        categoryRecipe.setIsFavorite(false);
        categoryRecipies.add(categoryRecipe);

        return categoryRecipies;
    }
}
