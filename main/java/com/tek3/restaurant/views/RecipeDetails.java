package com.tek3.restaurant.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.RecipeStepCustomArrayAdapter;
import com.tek3.restaurant.adapters.models.Recipe;
import com.tek3.restaurant.adapters.models.RecipeStep;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetails extends Activity {
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        recipe = (Recipe) getIntent().getSerializableExtra("recipe");

        TextView recipeNameTextView = (TextView) findViewById(R.id.recipeNameTextView);
        recipeNameTextView.setText(recipe.getRecipeName());

        TextView restaurantNameTextView = (TextView) findViewById(R.id.restaurantNameTextView);
        restaurantNameTextView.setText(recipe.getRestaurantName());

        TextView preparationTimeTextView = (TextView) findViewById(R.id.preparationTimeTextView);
        preparationTimeTextView.setText(recipe.getRecipePreparationTime() + " min.");

        Button buyRecipeButton = (Button) findViewById(R.id.buyRecipeButton);
        LinearLayout boughtRecipeInformationLinearLayout = (LinearLayout) findViewById(R.id.boughtRecipeInformationLinearLayout);

        if (!recipe.getIsBought()) {
            buyRecipeButton.setVisibility(View.VISIBLE);
            boughtRecipeInformationLinearLayout.setVisibility(View.GONE);
        }
        else {
            buyRecipeButton.setVisibility(View.GONE);
            boughtRecipeInformationLinearLayout.setVisibility(View.VISIBLE);

            RecipeStepCustomArrayAdapter adapter = new RecipeStepCustomArrayAdapter(this, initStaticRecipeSteps());

            ListView stepListView = (ListView) findViewById(R.id.stepsListView);
            stepListView.setAdapter(adapter);
            stepListView.setOnTouchListener(new View.OnTouchListener() {
                // Setting on Touch Listener for handling the touch inside ScrollView
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // Disallow the touch request for parent scroll on touch of child view
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<RecipeStep> initStaticRecipeSteps() {
        ArrayList<RecipeStep> recipeSteps = new ArrayList<RecipeStep>();
        RecipeStep recipeStep;

        recipeStep = new RecipeStep();
        recipeStep.setRecipeStepNumber("1");
        recipeStep.setRecipeStepDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ");
        recipeSteps.add(recipeStep);

        recipeStep = new RecipeStep();
        recipeStep.setRecipeStepNumber("2");
        recipeStep.setRecipeStepDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ");
        recipeSteps.add(recipeStep);

        recipeStep = new RecipeStep();
        recipeStep.setRecipeStepNumber("3");
        recipeStep.setRecipeStepDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ");
        recipeSteps.add(recipeStep);

        recipeStep = new RecipeStep();
        recipeStep.setRecipeStepNumber("4");
        recipeStep.setRecipeStepDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ");
        recipeSteps.add(recipeStep);

        return recipeSteps;
    }
}
