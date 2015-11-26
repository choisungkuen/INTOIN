package com.example.intoin.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intoin.myapplication.mainactivity.BaseActivity;
import com.example.intoin.myapplication.Myapplication;
import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;


/**
 * Created by choeseong-geun on 15. 10. 26..
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button intoin_join_bt;
    private EditText id_et ,pw_et;
    private SessionCallback callback = null;
    private TextView intoin_login_tv;
    private CheckBox checkBox;
    private Myapplication myapplication;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        myapplication = Myapplication.getGlobalApplicationContext();
        Log.e("해시키", myapplication.getPackageHashKey(LoginActivity.this));


        intoin_join_bt = (Button)findViewById(R.id.intoin_join_bt);
        intoin_login_tv = (TextView)findViewById(R.id.intoin_login_tv);
        id_et = (EditText)findViewById(R.id.id_et);
        pw_et = (EditText)findViewById(R.id.pw_et);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
        intoin_join_bt.setOnClickListener(this);
        intoin_login_tv.setOnClickListener(this);
        checkBox.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.intoin_login_tv:
                Intent intent = new Intent(LoginActivity.this , ExloginActivity.class);
                startActivity(intent);
                break;
            case R.id.intoin_join_bt:

                Util.JoinCompletePop(this, LoginActivity.this);
                break;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {

            redirectSignupActivity();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
        }
    }
    protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, SampleSignupActivity.class);
        startActivity(intent);
        finish();
    }






}

