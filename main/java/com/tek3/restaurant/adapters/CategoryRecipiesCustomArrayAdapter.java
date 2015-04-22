package com.tek3.restaurant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.models.Recipe;
import java.util.List;

/**
 * Created by gaby on 4/18/15.
 */
public class CategoryRecipiesCustomArrayAdapter extends ArrayAdapter<Recipe> {
    private LayoutInflater layoutInflater;
    private List<Recipe> categoryRecipeList;

    public CategoryRecipiesCustomArrayAdapter(Context context, List<Recipe> objects) {
        super(context, 0, objects);

        layoutInflater = LayoutInflater.from(context);
        categoryRecipeList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Recipe categoryRecipe = getItem(position);

        convertView = layoutInflater.inflate(R.layout.list_item_recipe, null);

        TextView categoryRecipeNameTextView = (TextView) convertView.findViewById(R.id.recipeNameTextView);
        categoryRecipeNameTextView.setText(categoryRecipe.getRecipeName());

        TextView categoryRecipePriceTextView = (TextView) convertView.findViewById(R.id.recipePriceTextView);
        categoryRecipePriceTextView.setText(categoryRecipe.getRecipePrice());

        return convertView;
    }
}
