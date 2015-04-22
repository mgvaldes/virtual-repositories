package com.tek3.restaurant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.models.Recipe;
import com.tek3.restaurant.adapters.models.RecipeStep;

import java.util.List;

/**
 * Created by gaby on 4/20/15.
 */
public class RecipeStepCustomArrayAdapter extends ArrayAdapter<RecipeStep> {
    private LayoutInflater layoutInflater;
    private List<RecipeStep> recipeStepsList;

    public RecipeStepCustomArrayAdapter(Context context, List<RecipeStep> objects) {
        super(context, 0, objects);

        layoutInflater = LayoutInflater.from(context);
        recipeStepsList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final RecipeStep recipeStep = getItem(position);

        convertView = layoutInflater.inflate(R.layout.list_item_recipe_steps, null);

        TextView stepNumberTextView = (TextView) convertView.findViewById(R.id.stepNumberTextView);
        stepNumberTextView.setText(recipeStep.getRecipeStepNumber());

        TextView recipeStepDescriptionTextView = (TextView) convertView.findViewById(R.id.stepDescriptionTextView);
        recipeStepDescriptionTextView.setText(recipeStep.getRecipeStepDescription());

        ImageView recipeStepImageView = (ImageView) convertView.findViewById(R.id.stepImageView);

        return convertView;
    }
}
