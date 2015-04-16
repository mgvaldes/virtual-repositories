package com.tek3.restaurant.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tek3.restaurant.R;

/**
 * Created by root on 15/04/15.
 */
public class RestaurantDetails extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Button restaurantCategoriesButton = (Button) findViewById(R.id.restaurantCategoriesButton);
        restaurantCategoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codeValidationActivity = new Intent(RestaurantDetails.this, Sponsor.class);
                RestaurantDetails.this.startActivity(codeValidationActivity);
            }
        });
    }
}