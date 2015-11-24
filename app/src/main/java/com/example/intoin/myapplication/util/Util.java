package com.example.intoin.myapplication.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.mainactivity.CustomerAddActivity;
import com.example.intoin.myapplication.mainactivity.LineAddActivity;
import com.example.intoin.myapplication.viewpager.ViewpagerActivity;


/**
 * Created by choeseong-geun on 15. 10. 29..
 */
public class Util {


    //회원가입 성공 팝
    public static void JoinCompletePop(Context context,final Activity activity) {
        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.login_dialog, null);
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



    // 메시지 팝업
    public static void MSGCompletePop(Context context,final Activity activity, String text) {
        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.msg_dialog, null);
        view.setBackgroundColor(Color.TRANSPARENT);
        Button ok_bt = (Button)view.findViewById(R.id.ok_bt);
        TextView textView = (TextView)view.findViewById(R.id.textView3);


//        String text 변수에 서버에서 Response msg 값 전달받음

        if("".equals(text) || text == null){
            text = "메세지 보내기가 완료되었습니다.";

        }
        textView.setText(text);
        ab.setView(view);
        final AlertDialog dialog1 = ab.create();
        ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


    // 고객삭제 팝업
    public static void CustomerDeletePop(Context context,final Activity activity, String text) {
        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.customer_dialog, null);
        view.setBackgroundColor(Color.TRANSPARENT);
        Button ok_bt = (Button)view.findViewById(R.id.ok_bt);
        TextView textView = (TextView)view.findViewById(R.id.textView3);


//        String text 변수에 등록된이름 전달받아서 처리

        textView.setText(text+"을 삭제하시겠습니까?");
        ab.setView(view);
        final AlertDialog dialog1 = ab.create();
        ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


    // 라인등록 고객등록 팝업
    public static void CustomerAddePop(final Context context,final Activity activity) {
        AlertDialog.Builder ab = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.customeradd_dialog, null);
        view.setBackgroundColor(Color.TRANSPARENT);
        Button ok_bt = (Button)view.findViewById(R.id.ok_bt);
        ListView listview = (ListView)view.findViewById(R.id.listview);
        String[] sw = new String[]{"고객등록","LINE 등록"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,android.R.layout.simple_list_item_1,sw);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Util.Intent(context, CustomerAddActivity.class);
                } else {
                    Util.Intent(context, LineAddActivity.class);
                }

            }
        });
        ab.setView(view);
        final AlertDialog dialog1 = ab.create();
        ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    //상세페이지 커스텀 액션바

    public static void DeatailActionBar(final Context context, TextView textView, String title, Button button1, Button button2){
        textView.setText(title);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).onBackPressed();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , "링크",Toast.LENGTH_SHORT).show();
            }
        });

    }


    public static void LineCustomerActionBar(final Context context, TextView textView, String title, Button button1, TextView textView2){
        textView.setText(title);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).onBackPressed();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).onBackPressed();
            }
        });

    }



    //인텐트

    public static void Intent(Context context ,Class activity ){
        Intent intent = new Intent(context , activity);
        context.startActivity(intent);
    }





}
