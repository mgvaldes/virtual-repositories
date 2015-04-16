package com.tek3.restaurant.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tek3.restaurant.R;

/**
 * Created by root on 15/04/15.
 */
public class Sponsor extends Activity {
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent restaurantDetailsActivity = new Intent(Sponsor.this, RestaurantDetails.class);
                Sponsor.this.startActivity(restaurantDetailsActivity);
                Sponsor.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}