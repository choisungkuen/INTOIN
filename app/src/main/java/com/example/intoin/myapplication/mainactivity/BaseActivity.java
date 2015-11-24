package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.content.Intent;

import com.example.intoin.myapplication.Myapplication;
import com.example.intoin.myapplication.login.LoginActivity;
import com.example.intoin.myapplication.login.SampleSignupActivity;
import com.example.intoin.myapplication.login.WaitingDialog;


public class BaseActivity extends Activity {
    protected static Activity self;

    @Override
    protected void onResume() {
        super.onResume();
        Myapplication.setCurrentActivity(this);
        self = BaseActivity.this;
    }

    @Override
    protected void onPause() {
        clearReferences();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences() {
        Activity currActivity = Myapplication.getCurrentActivity();
        if (currActivity != null && currActivity.equals(this)) {
            Myapplication.setCurrentActivity(null);
        }
    }

    protected static void showWaitingDialog() {
        WaitingDialog.showWaitingDialog(self);
    }

    protected static void cancelWaitingDialog() {
        WaitingDialog.cancelWaitingDialog();
    }

    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, SampleSignupActivity.class);
        startActivity(intent);
        finish();
    }
}
