package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class MessageActivity extends Activity implements View.OnClickListener{

    Button message_add_bt;
    ListView message_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this,textView,"메세지 상대 선택" ,button);


        message_add_bt = (Button)findViewById(R.id.message_add_bt);
        message_listview = (ListView)findViewById(R.id.message_listview);
        message_add_bt.setOnClickListener(this);



        String[] sw = new String[]{"전체","VIP","LINE","본부장","팀장","팀원","SK","미지정","김수진부장","김철수","이영희","테스트","테스트","테스트"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.message_list_row ,R.id.message_tv,sw);
        message_listview.setAdapter(adapter);
        message_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.message_add_bt:
                Util.Intent(this, MessageContentActivity.class);
                break;
        }

    }
}
