package com.androidhive.flashlight.flashlight;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;


public class SettingsActivity extends BaseActivity {


    private static final String TAG = "SettingsActivity: ";
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
            case R.id.torch_activated:
                if (checked) {
                    // Put some meat on the sandwich
                    Log.i(TAG, "onTorchCheckboxClicked: ");
                    break;
                }else {
                    Log.i(TAG, "onTorchCheckboxNOTClicked: ");
                    break;
                }
            case R.id.battery_warning:
                if (checked) {
                    Log.i(TAG, "onBatteryheckboxClicked: ");
                    break;
                }else {
                    Log.i(TAG, "onBatteryheckboxNOTClicked: ");
                    break;
                }

        }
    }


}

