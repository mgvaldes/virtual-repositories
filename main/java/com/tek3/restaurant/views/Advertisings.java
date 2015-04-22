package com.tek3.restaurant.views;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tek3.restaurant.R;
import com.tek3.restaurant.adapters.AdvertisingsCustomArrayAdapter;
import com.tek3.restaurant.adapters.models.Advertising;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgvaldes on 22/04/15.
 */
public class Advertisings extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisings);

        AdvertisingsCustomArrayAdapter adapter = new AdvertisingsCustomArrayAdapter(this, initStaticAdvertisings());

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        Advertising selectedAdvertising = (Advertising) getListView().getItemAtPosition(position);

        //TODO
        Intent advertisingDetailsActivity = new Intent(Advertisings.this, Recipies.class);

        Advertisings.this.startActivity(advertisingDetailsActivity);
    }

    public List<Advertising> initStaticAdvertisings() {
        ArrayList<Advertising> advertisings = new ArrayList<Advertising>();
        Advertising advertising;

        advertising = new Advertising("Promoción 1", "http://www.gastronomiaycia.com/wp-content/uploads/2011/10/ideas_vegetarianas_entrante.jpg");
        advertisings.add(advertising);

        advertising = new Advertising("Promoción 2", "http://www.gastronomiaycia.com/wp-content/uploads/2011/10/ideas_vegetarianas_entrante.jpg");
        advertisings.add(advertising);

        advertising = new Advertising("Promoción 3", "http://www.gastronomiaycia.com/wp-content/uploads/2011/10/ideas_vegetarianas_entrante.jpg");
        advertisings.add(advertising);

        return advertisings;
    }
}