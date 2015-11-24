package com.example.intoin.myapplication.mainactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.intoin.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by choeseong-geun on 15. 11. 17..
 */
public class SearchActivity extends FragmentActivity implements View.OnClickListener{

    Button search_del_bt;
    EditText search_et;
    TextView search_tv1 ,search_tv2;
    ListView search_list;

    String[] items;

    ArrayList<String> listItems;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        search_del_bt = (Button)findViewById(R.id.search_del_bt);
        search_et = (EditText)findViewById(R.id.search_et);
        search_tv1 = (TextView)findViewById(R.id.search_tv1);
        search_tv2 = (TextView)findViewById(R.id.search_tv2);
        search_list = (ListView)findViewById(R.id.search_list);

        initList();


        search_del_bt.setOnClickListener(this);
        search_tv1.setOnClickListener(this);
        search_tv2.setOnClickListener(this);

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){


                    initList();

                }

                else{



                    searchItem(s.toString());

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_del_bt:
                break;

            case R.id.search_tv1:
                break;

            case R.id.search_tv2:
                break;




        }
    }

    public void initList(){

        items=new String[]{"작전동","부산해운대","부천"};

        listItems=new ArrayList<>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(this,
                R.layout.search_list_row, R.id.search_text, listItems);

        search_list.setAdapter(adapter);

    }

    public void searchItem(String textToSearch){

        for(String item:items){

            if(!item.contains(textToSearch)){

                listItems.remove(item);

            }

        }

        adapter.notifyDataSetChanged();

    }

}
