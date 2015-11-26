package com.example.intoin.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class PopularitySearchFragment extends Fragment implements View.OnClickListener{

    Button search_del_bt;
    EditText search_et;
    TextView search_tv1 ,search_tv2;
    ListView search_list;

    String[] items;

    ArrayList<String> listItems;

    ArrayAdapter<String> adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_activity, container, false);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();



        search_list = (ListView)getView().findViewById(R.id.search_list);

        initList();




    }


    @Override
    public void onClick(View v) {

    }

    public void initList(){

        items=new String[]{"작전동","부산해운대","부천"};

        listItems=new ArrayList<>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(getActivity(),
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
