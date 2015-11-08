package com.example.intoin.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.Myapplication;
import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;


/**
 * Created by choeseong-geun on 15. 10. 30..
 */
public class SearchIDcompleteActivity extends Activity implements View.OnClickListener{




    Myapplication myapplication;
    //서버에 요청해서 받을 TextView
    TextView id_tv;
    Button password_search_bt, login_bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serach_complete_id);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this, textView, "아이디 찾기", button);
        myapplication = Myapplication.getGlobalApplicationContext();
        id_tv = (TextView)findViewById(R.id.id_tv);
        password_search_bt = (Button)findViewById(R.id.password_search_bt);
        login_bt = (Button)findViewById(R.id.login_bt);

        login_bt.setOnClickListener(this);
        password_search_bt.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.password_search_bt:


                break;
            case R.id.login_bt:
                intent = new Intent(myapplication, LoginActivity.class);
                startActivity(intent);


                break;




        }

    }
}
