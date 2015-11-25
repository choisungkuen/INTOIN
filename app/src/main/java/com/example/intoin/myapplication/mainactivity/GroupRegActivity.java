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
public class GroupRegActivity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_reg_list);
        TextView textView = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.icon);
        Util.CustomActionBar(this,textView,"그룹관리" ,button);




        ListView listview = (ListView)findViewById(R.id.grouplist_listview);
        String[] sw = new String[]{"전체","VIP","LINE","본부장"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.group_reg_list_row ,R.id.group_list_tv,sw);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                UI 테스트를 위해 임시로 이렇게 씀.
                Button reg_bt = (Button)parent.findViewById(R.id.reg_bt);


                reg_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Util.GroupAndLineNameReg(GroupRegActivity.this,"그룹명 편집", "팀원");
                    }
                });
                Button del_bt = (Button)view.findViewById(R.id.del_bt);

            }
        });
    }
}
