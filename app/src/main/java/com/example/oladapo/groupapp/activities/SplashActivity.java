package com.example.oladapo.groupapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.oladapo.groupapp.R;

/**
 * Simple Splash Activity.
 * Splash Activity would cause a delay of 3 second before timing out
 */

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    private static final String PREFS = "version";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove the titel bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);

                // Pause finished splashscreen
                finish();
            }
        }, SPLASH_TIME_OUT);

        };

    }



