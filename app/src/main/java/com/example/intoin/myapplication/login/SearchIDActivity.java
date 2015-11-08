package com.example.intoin.myapplication.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intoin.myapplication.Myapplication;
import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;


/**
 * Created by choeseong-geun on 15. 10. 30..
 */
public class SearchIDActivity extends Activity implements View.OnClickListener{


    Myapplication myapplication;
    Button id_serch_bt;
    EditText name_et, pnum_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_id);

        myapplication = Myapplication.getGlobalApplicationContext();
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this, textView, "아이디 찾기", button);
        id_serch_bt = (Button)findViewById(R.id.id_serch_bt);
        name_et =(EditText)findViewById(R.id.name_et);
        pnum_et = (EditText)findViewById(R.id.pnum_et);

        id_serch_bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_serch_bt:
                Intent intent = new Intent(myapplication, SearchIDcompleteActivity.class);
                startActivity(intent);
                break;



        }

    }
}
