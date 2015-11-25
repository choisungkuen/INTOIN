package com.example.intoin.myapplication.fragment.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.mainactivity.GroupRegActivity;
import com.example.intoin.myapplication.util.Util;
import com.unnamed.b.atv.model.TreeNode;
/**
 * Created by choeseong-geun on 15. 11. 19..
 */
public class ButtonHolder extends TreeNode.BaseNodeViewHolder<ButtonHolder.ButtonItem> implements View.OnClickListener {



    public ButtonHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, ButtonItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.customer_group_button_row, null, false);
        Button group_bt = (Button)view.findViewById(R.id.group_bt);
        group_bt.setOnClickListener(this);
        return view;
    }

    @Override
    public void toggle(boolean active) {
    }


    public static class ButtonItem {
        public int icon;

        public ButtonItem() {

        }
        // rest will be hardcoded
    }

    @Override
    public void onClick(View v) {

        Util.Intent(context , GroupRegActivity.class);

    }
}
