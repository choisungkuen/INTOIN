package com.example.intoin.myapplication.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.viewpager.ViewpagerActivity;


/**
 * Created by choeseong-geun on 15. 10. 29..
 */
public class Util {


    //회원가입 성공 팝
    public static void JoinCompletePop(Context context,final Activity activity) {
        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.custom_dialog, null);
        view.setBackgroundColor(Color.TRANSPARENT);
        Button ok_bt = (Button)view.findViewById(R.id.ok_bt);
        ab.setView(view);
        final AlertDialog dialog1 = ab.create();
        ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ViewpagerActivity.class);
                activity.startActivity(intent);
                dialog1.dismiss();
            }
        });
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog1.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog1.show();
        Window window = dialog1.getWindow();
        window.setAttributes(lp);

    }

    //로그인 커스텀 액션바

    public static void CustomActionBar(final Context context, TextView textView, String title, Button button){
        textView.setText(title);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).onBackPressed();
            }
        });

    }


    //인텐트

    public static void Intent(Context context ,Class activity ){
        Intent intent = new Intent(context , activity);
        context.startActivity(intent);
    }





}
