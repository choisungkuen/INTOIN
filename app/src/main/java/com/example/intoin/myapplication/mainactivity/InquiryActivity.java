package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class InquiryActivity extends Activity implements View.OnClickListener{

    Button inquiry_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inquiry);

        TextView textView = (TextView)findViewById(R.id.text);
        Button button1 = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this, textView, "문의하기", button1);

        inquiry_Bt = (Button)findViewById(R.id.inquiry_Bt);
        inquiry_Bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inquiry_Bt:
                Util.MSGCompletePop(InquiryActivity.this , "문의가 완료되었습니다.");
                break;
        }
    }
}
