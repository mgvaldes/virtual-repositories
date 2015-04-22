package com.tek3.restaurant.views;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.RestaurantCategoriesCustomArrayAdapter;
import com.tek3.restaurant.adapters.models.RestaurantCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15/04/15.
 */
public class RestaurantCategories extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_categories);

        RestaurantCategoriesCustomArrayAdapter adapter = new RestaurantCategoriesCustomArrayAdapter(this, initStaticRestaurantCategories());

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        RestaurantCategory selectedRestaurantCategory = (RestaurantCategory) getListView().getItemAtPosition(position);

        Intent categoryRecipiesActivity = new Intent(RestaurantCategories.this, CategoryRecipies.class);

        RestaurantCategories.this.startActivity(categoryRecipiesActivity);
    }

    public List<RestaurantCategory> initStaticRestaurantCategories() {
        ArrayList<RestaurantCategory> restaurantCategories = new ArrayList<RestaurantCategory>();
        RestaurantCategory restaurantCategory;

        restaurantCategory = new RestaurantCategory("Entrantes", "http://www.gastronomiaycia.com/wp-content/uploads/2011/10/ideas_vegetarianas_entrante.jpg");
        restaurantCategories.add(restaurantCategory);

        restaurantCategory = new RestaurantCategory("Carnes", "http://ddrmn13.preview.sasites.com.mx/img/upload/carnes-asadas-beto-i-1.jpg");
        restaurantCategories.add(restaurantCategory);

        restaurantCategory = new RestaurantCategory("Mariscos y Pescados", "http://www.laboratoriolcn.com/f/imagenes/Alimentos/pescados_y_mariscos.jpg");
        restaurantCategories.add(restaurantCategory);

        restaurantCategory = new RestaurantCategory("Aves", "http://2.bp.blogspot.com/-AbeX2C4ShOE/UfZxL13dlzI/AAAAAAAAGnQ/VR6XOn8O6m4/s1600/pollo-asado+con+papas+fritas.jpg");
        restaurantCategories.add(restaurantCategory);

        restaurantCategory = new RestaurantCategory("Postres", "http://www.meals.com/ImagesRecipes/145357stn.jpg");
        restaurantCategories.add(restaurantCategory);

        return restaurantCategories;
    }
}