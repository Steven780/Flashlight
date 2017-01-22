package com.androidhive.flashlight.flashlight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;


public class SettingsActivity extends BaseActivity {

    //Here we are customising the menu for this activity by removing the settings option.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.settings_activity_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked) {
                    // Put some meat on the sandwich
                }else {
                    // Remove the meat
                    break;
                }
            case R.id.checkbox_cheese:
                if (checked) {
                    // Cheese me
                }else {
                    // I'm lactose intolerant
                    break;
                }
            // TODO: Veggie sandwich
        }
    }


}

