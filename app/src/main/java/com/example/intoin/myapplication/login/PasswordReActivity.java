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
public class PasswordReActivity extends Activity{
    Button pass_ok_bt;
    EditText newpwre_et, newpw_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_re);



        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this, textView, "비밀번호 재설정", button);

        pass_ok_bt = (Button)findViewById(R.id.pass_ok_bt);
        newpwre_et = (EditText)findViewById(R.id.newpwre_et);
        newpw_et = (EditText)findViewById(R.id.newpw_et);


        pass_ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordReActivity.this , ExloginActivity.class);
                startActivity(intent);
            }
        });







    }

}
