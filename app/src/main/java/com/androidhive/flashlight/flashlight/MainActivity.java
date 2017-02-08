package com.androidhive.flashlight.flashlight;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends BaseActivity {

    private ImageButton btnSwitch;
    private CameraManager mCameraManager;
    private String mCameraId;
    private boolean isFlashOn;
    private boolean hasFlash;
    private static final String TAG = "MainActivityActivity: ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // flash switch button
        btnSwitch = (ImageButton) findViewById(R.id.btnSwitch);
        isFlashOn=true;


 /*
 * First check if device is supporting flashlight or not
 */
        /*
        hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        checkFlashlight(hasFlash);  //Will display dialog box indicating no flash available on device

        //Returns error dialog if no flash on device
        if(!hasFlash){
            return; //IF no flashlight exists on device, escape from onCreate
        }
        */

        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE); //Only added in Lollipop	5.0	API level 21
        try {
            mCameraId = mCameraManager.getCameraIdList()[0]; //Returns the currently connected camera device

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        //Only when button is pressed
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isFlashOn) {
                        turnOffFlashLight();
                        isFlashOn = false;
                    } else {
                        turnOnFlashLight();
                        isFlashOn = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public void turnOnFlashLight() {

        try {
            //If version 6.0 Marshmallow or higher run torch
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Log.i(TAG, "Light on!");
                mCameraManager.setTorchMode(mCameraId, true); // setTorchMode api >=23
               //playOnOffSound();
                btnSwitch.setImageResource(R.drawable.on);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void turnOffFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Log.i(TAG, "Light off!");
                mCameraManager.setTorchMode(mCameraId, false); // setTorchMode api >=23
                //playOnOffSound();
                btnSwitch.setImageResource(R.drawable.off);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    /**
     * If device does not support flashlight then alert dialog will inform user
     * upon user confirmation of message, system will exit
     * @param flash - boolean signifying if flash supported
     */
    public void checkFlashlight(boolean flash){

        if (!flash) {
            // device doesn't support flash
            // Show alert message and close the application
            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, your device doesn't support flash light!");

            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // closing the application
                    finish();
                    System.exit(0);
                }
            });

            alert.show();
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        if(isFlashOn){
            turnOffFlashLight();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isFlashOn){
            turnOffFlashLight();
        }
    }


    /*This function runs after onCreate method,
    * therefore, light will always turn on as app starts if
    * isFlashOn = true*/
    @Override
    protected void onResume() {
        super.onResume();
        if(isFlashOn){
            turnOnFlashLight();
        }
    }



}


