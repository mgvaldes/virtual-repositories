package com.tek3.restaurant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.models.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaby on 4/18/15.
 */
public class RecipiesCustomArrayAdapter extends ArrayAdapter<Recipe> {
    private LayoutInflater layoutInflater;
    private List<Recipe> recipeList;
    private Filter filter;

    public RecipiesCustomArrayAdapter(Context context, List<Recipe> objects) {
        super(context, 0, objects);

        layoutInflater = LayoutInflater.from(context);
        recipeList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Recipe categoryRecipe = getItem(position);

        convertView = layoutInflater.inflate(R.layout.list_item_recipe, null);

        TextView recipeNameTextView = (TextView) convertView.findViewById(R.id.recipeNameTextView);
        recipeNameTextView.setText(categoryRecipe.getRecipeName());

        TextView recipePriceTextView = (TextView) convertView.findViewById(R.id.recipePriceTextView);
        recipePriceTextView.setText(categoryRecipe.getRecipePrice());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new RecipiesCustomArrayAdapterFilter(recipeList);
        }

        return filter;
    }

    private class RecipiesCustomArrayAdapterFilter extends Filter {
        private List<Recipe> recipies;

        public RecipiesCustomArrayAdapterFilter(List<Recipe> source) {
            recipies = new ArrayList<Recipe>();

            synchronized (this) {
                recipies.addAll(source);
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterSeq = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();

            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<Recipe> filter = new ArrayList<Recipe>();

                for (Recipe recipe : recipies) {
                    // the filtering itself: TODO Preguntar por que atributos de una receta se hara este filtrado!
                    if (recipe.getRecipeName().toLowerCase().contains(filterSeq)) {
                        filter.add(recipe);
                    }
                }

                result.count = filter.size();
                result.values = filter;
            }
            else {
                // add all objects
                synchronized (this) {
                    result.values = recipies;
                    result.count = recipies.size();
                }
            }

            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<Recipe> filtered = (ArrayList<Recipe>) results.values;

            notifyDataSetChanged();
            clear();

            for (int i = 0, l = filtered.size(); i < l; i++) {
                add((Recipe) filtered.get(i));
            }

            notifyDataSetInvalidated();
        }
    }
}
