package com.example.intoin.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.intoin.myapplication.R;


/**
 * Created by choeseong-geun on 15. 10. 26..
 */
public class SplashActivity extends Activity {

    private static long SLEEP_TIME = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intoin_0_intro);

          // Removes notification bar



        // Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();

    }

    private class IntentLauncher extends Thread {
        @Override
        /**
         * Sleep for some time and than start new activity.
         */
        public void run() {
            try {
                // Sleeping
                Thread.sleep(SLEEP_TIME * 1000);
            } catch (Exception e) {

            }

            // Start main activity
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            SplashActivity.this.startActivity(intent);
            SplashActivity.this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
