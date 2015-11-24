package com.example.intoin.myapplication.fragment.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.mainactivity.CustomerInfoActivity;
import com.example.intoin.myapplication.mainactivity.LineInfoActivity;
import com.example.intoin.myapplication.util.Util;
import com.unnamed.b.atv.model.TreeNode;

/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class PlaceHolderHolder extends TreeNode.BaseNodeViewHolder<PlaceHolderHolder.PlaceItem> implements View.OnClickListener {

    private String type;

    public PlaceHolderHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, PlaceItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;
        if("".equals(value.type) || value.type ==null){
            view = inflater.inflate(R.layout.customer_child_row, null, false);
            TextView placeName = (TextView) view.findViewById(R.id.child_text);
            placeName.setText(value.name);
            this.type = null;
        }else{
            view = inflater.inflate(R.layout.customer_group_child_row, null , false);
            TextView placeName = (TextView) view.findViewById(R.id.child_text);
            placeName.setText(value.name);
            this.type = value.type;
        }
        view.setOnClickListener(this);



        return view;
    }

    @Override
    public void toggle(boolean active) {
    }


    public static class PlaceItem {
        public String name;
        public String type;

        public PlaceItem(String name , String type) {
            this.name = name;
            this.type = type;
        }
        // rest will be hardcoded
    }

    @Override
    public void onClick(View v) {
        if(type != null){

            Util.Intent(context, CustomerInfoActivity.class);
        }else{
            Util.Intent(context, LineInfoActivity.class);
        }



    }
}
