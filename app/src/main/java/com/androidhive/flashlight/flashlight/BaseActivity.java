package com.androidhive.flashlight.flashlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends AppCompatActivity {


    public static final String TAG = "BaseActivity: ";
    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }


    //Processing menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_settings:

                //Launching SettingsActivity
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);


                return  true;

            case R.id.menu_about:
                Log.i(TAG, "About Clicked");
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
