package com.example.intoin.myapplication.fragment.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.mainactivity.LineInfoActivity;
import com.example.intoin.myapplication.util.Util;
import com.unnamed.b.atv.model.TreeNode;

import java.util.Random;

public class SocialViewHolder extends TreeNode.BaseNodeViewHolder<SocialViewHolder.SocialItem> implements View.OnClickListener{



    public SocialViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, SocialItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.customer_child_row, null, false);

        view.setOnClickListener(this);
        TextView connectionsLabel = (TextView) view.findViewById(R.id.child_text);
        Random r = new Random();
        connectionsLabel.setText(r.nextInt(90) + "0-1234-1234");


        return view;
    }

    @Override
    public void toggle(boolean active) {
    }


    public static class SocialItem {
        public int icon;

        public SocialItem() {

        }
        // rest will be hardcoded
    }

    @Override
    public void onClick(View v) {
        Util.Intent(context, LineInfoActivity.class);
    }
}
