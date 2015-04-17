package com.tek3.restaurant.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tek3.restaurant.GlobalState;
import com.tek3.restaurant.R;

public class CodeValidation extends Activity {
    GlobalState globalState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_validation);

        globalState = ((GlobalState) getApplicationContext());

        TextView restaurantCodeTextView = (TextView) findViewById(R.id.restaurantCodeTextView);
        restaurantCodeTextView.setText(globalState.getLanguageResources().get("restaurant_code_text"));

        TextView termsAndConditionsTextView = (TextView) findViewById(R.id.termsAndConditionsTextView);
        termsAndConditionsTextView.setText(globalState.getLanguageResources().get("terms_and_conditions_text"));

        Button codeValidationButton = (Button) findViewById(R.id.codeValidationButton);
        codeValidationButton.setText(globalState.getLanguageResources().get("enter_button_text"));
        codeValidationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codeValidationActivity = new Intent(CodeValidation.this, Sponsor.class);
                CodeValidation.this.startActivity(codeValidationActivity);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_validation, menu);
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
