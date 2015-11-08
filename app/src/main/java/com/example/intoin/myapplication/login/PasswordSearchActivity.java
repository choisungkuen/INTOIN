package com.example.intoin.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;


/**
 * Created by choeseong-geun on 15. 10. 30..
 */
public class PasswordSearchActivity extends Activity{
    Button pass_next_bt;
    EditText id_et, name_et, pnum_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_password);

        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this, textView, "비밀번호 찾기", button);

        pass_next_bt=(Button)findViewById(R.id.pass_next_bt);
        id_et = (EditText)findViewById(R.id.id_et);
        name_et = (EditText)findViewById(R.id.name_et);
        pnum_et = (EditText)findViewById(R.id.pnum_et);


        pass_next_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordSearchActivity.this,PasswordReActivity.class);
                startActivity(intent);
            }
        });

    }
}
