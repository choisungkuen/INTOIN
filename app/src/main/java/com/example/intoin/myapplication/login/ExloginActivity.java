package com.example.intoin.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intoin.myapplication.Myapplication;
import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;


/**
 * Created by choeseong-geun on 15. 10. 30..
 */
public class ExloginActivity extends Activity implements View.OnClickListener{

    EditText id_et ,pw_et;
    CheckBox checkBox;
    Button intoin_login_bt;
    TextView id_serch_tv, pw_serch_tv;
    Myapplication myapplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_existing);


        myapplication = Myapplication.getGlobalApplicationContext();


        id_et = (EditText)findViewById(R.id.id_et);
        pw_et = (EditText)findViewById(R.id.pw_et);
        intoin_login_bt = (Button)findViewById(R.id.intoin_login_bt);
        id_serch_tv = (TextView)findViewById(R.id.id_serch_tv);
        pw_serch_tv =(TextView)findViewById(R.id.pw_serch_tv);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        intoin_login_bt.setOnClickListener(this);
        id_serch_tv.setOnClickListener(this);
        pw_serch_tv.setOnClickListener(this);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this,textView,"기존아이디 로그인" ,button);



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.intoin_login_bt:

                break;
            case R.id.id_serch_tv:
                intent = new Intent(this, SearchIDActivity.class);
                startActivity(intent);

                break;
            case R.id.pw_serch_tv:
                intent= new Intent(this, PasswordSearchActivity.class);
                startActivity(intent);
                break;


        }

    }
}
