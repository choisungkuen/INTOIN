package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class CustomerAddActivity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_add);
        Button button1 = (Button)findViewById(R.id.icon);
        TextView text = (TextView)findViewById(R.id.text);
        TextView complete_tv = (TextView)findViewById(R.id.complete_tv);
        Util.LineCustomerActionBar(this, text, "고객 추가", button1, complete_tv);
    }
}
