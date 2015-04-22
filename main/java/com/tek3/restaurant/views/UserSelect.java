package com.tek3.restaurant.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.tek3.restaurant.GlobalState;
import com.tek3.restaurant.R;

public class UserSelect extends Activity {
    private GlobalState globalState;
    private Spinner languagesOptions;
    private Button clientButton;
    private Button restaurantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        globalState = ((GlobalState) getApplicationContext());

        languagesOptions = (Spinner) findViewById(R.id.languagesOptions);
        languagesOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                globalState.changeLanguageOption(languagesOptions.getSelectedItem().toString());

                clientButton.setText(globalState.getLanguageResources().get("client_button_text"));
                clientButton.invalidate();

                restaurantButton.setText(globalState.getLanguageResources().get("restaurant_button_text"));
                restaurantButton.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String selectedLanguageOption = languagesOptions.getSelectedItem().toString();

        globalState.loadLanguageResources(selectedLanguageOption);

        clientButton = (Button) findViewById(R.id.clientButton);
        clientButton.setText(globalState.getLanguageResources().get("client_button_text"));
        clientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codeValidationActivity = new Intent(UserSelect.this, CodeValidation.class);
                UserSelect.this.startActivity(codeValidationActivity);
            }
        });

        restaurantButton = (Button) findViewById(R.id.restaurantButton);
        restaurantButton.setText(globalState.getLanguageResources().get("restaurant_button_text"));
        restaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(UserSelect.this, Login.class);
                UserSelect.this.startActivity(loginActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_select, menu);
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
}
