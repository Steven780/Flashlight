package com.androidhive.flashlight.flashlight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;


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

    }

}

