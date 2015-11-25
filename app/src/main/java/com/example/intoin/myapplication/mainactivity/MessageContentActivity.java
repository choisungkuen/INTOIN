package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class MessageContentActivity extends Activity implements View.OnClickListener{

    EditText message_content_et;
    TextView message_content_tv;
    Button message_content_bt, message_groupadd_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_content);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this,textView,"메세지 입력" ,button);

        message_content_et = (EditText)findViewById(R.id.message_content_et);
        message_content_tv = (TextView)findViewById(R.id.message_content_tv);
        message_content_bt = (Button)findViewById(R.id.message_content_bt);
        message_groupadd_bt = (Button)findViewById(R.id.message_groupadd_bt);


        message_content_bt.setOnClickListener(this);
        message_groupadd_bt.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_content_bt:
                Util.MSGCompletePop(MessageContentActivity.this,"");
                break;
            case R.id.message_groupadd_bt:
                Util.Intent(this, MessageActivity.class);
                break;

        }
    }
}
