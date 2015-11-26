package com.example.intoin.myapplication.mainactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;

import java.util.ArrayList;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class GroupRegActivity extends Activity implements View.OnClickListener{


    Button group_add_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_reg_list);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this,textView,"그룹관리" ,button);


        group_add_bt = (Button)findViewById(R.id.group_add_bt);
        group_add_bt.setOnClickListener(this);


        ListView listview = (ListView)findViewById(R.id.grouplist_listview);
        String[] sw = new String[]{"전체","VIP","LINE","본부장"};
        ArrayList<String> item = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.group_reg_list_row ,R.id.group_list_tv,sw);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(GroupRegActivity.this, position+"", Toast.LENGTH_SHORT).show();

                //ui 테스트 용으로 이렇게 사용 Adapter 따로 구현해야함.
                Button reg_bt =  (Button)view.findViewById(R.id.reg_bt);
                Button del_bt =  (Button)view.findViewById(R.id.del_bt);
                reg_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Util.GroupAndLineNameReg(GroupRegActivity.this,"그룹명 편집","테스트","");
                    }
                });

                del_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.group_add_bt:
                Util.GroupAndLineNameReg(GroupRegActivity.this,"그룹추가",null,"ADD");
                break;
        }

    }
}
