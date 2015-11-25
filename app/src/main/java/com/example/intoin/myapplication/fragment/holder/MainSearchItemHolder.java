package com.example.intoin.myapplication.fragment.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.unnamed.b.atv.model.TreeNode;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class MainSearchItemHolder extends TreeNode.BaseNodeViewHolder<MainSearchItemHolder.LayoutInfo>  {



    public MainSearchItemHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, LayoutInfo value) {
        View view = null;

        final LayoutInflater inflater = LayoutInflater.from(context);

        switch (value.type){

            case "MGM":
                view = inflater.inflate(R.layout.main_mgm_search_item_row, null, false);
                TextView search_item_name = (TextView)view.findViewById(R.id.search_item_name);
                TextView search_item_addres = (TextView)view.findViewById(R.id.search_item_addres);
                TextView search_item_price = (TextView)view.findViewById(R.id.search_item_price);
                TextView search_item_date = (TextView)view.findViewById(R.id.search_item_date);

                break;

            case "MODEL":

                view = inflater.inflate(R.layout.main_model_search_item_row, null, false);
                TextView model_search_item_name = (TextView)view.findViewById(R.id.model_search_item_name);
                TextView model_search_item_adr = (TextView)view.findViewById(R.id.model_search_item_adr);
                TextView model_search_item_add = (TextView)view.findViewById(R.id.model_search_item_add);

                break;

            case "CUSTOMER":
                view = inflater.inflate(R.layout.main_customer_search_item_row, null, false);
                TextView main_customer_name_tv = (TextView)view.findViewById(R.id.main_customer_name_tv);
                main_customer_name_tv.setText(value.main_customer_name_tv);
                break;

        }
//        if("MGM".equals(value.type)){
//            view = inflater.inflate(R.layout.main_mgm_search_item_row, null, false);
//
//        }


        return view;
    }

    @Override
    public void toggle(boolean active) {
    }


    public static class LayoutInfo {

        //mgm, 고객 , 모델하우스 구분 해서 레이아웃 처리해야됨
        public String type;



        public String search_item_name;
        public String search_item_addres;
        public String search_item_price;
        public String search_item_date;
        public String model_search_item_add;
        public String main_customer_name_tv;

        public LayoutInfo(String type ,String search_item_name ,String search_item_addres ,String search_item_price ,String search_item_date , String model_search_item_add , String main_customer_name_tv) {

            this.type = type;
            this.search_item_name = search_item_name;
            this.search_item_addres = search_item_addres;
            this.search_item_price = search_item_price;
            this.search_item_date = search_item_date;
            this.model_search_item_add = model_search_item_add;
            this.main_customer_name_tv = main_customer_name_tv;



        }
        // rest will be hardcoded
    }


}
