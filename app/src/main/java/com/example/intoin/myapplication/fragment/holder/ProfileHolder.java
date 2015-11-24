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
public class ProfileHolder extends TreeNode.BaseNodeViewHolder<MainTreeItemHolder.IconTreeItem> {


    public ProfileHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, MainTreeItemHolder.IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.customer_header_row, null, false);
        TextView tvValue = (TextView) view.findViewById(R.id.header_text);
        tvValue.setText(value.text);


        return view;
    }

    @Override
    public void toggle(boolean active) {
    }

}
