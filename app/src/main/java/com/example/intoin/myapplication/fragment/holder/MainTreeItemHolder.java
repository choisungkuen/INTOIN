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
public class MainTreeItemHolder extends TreeNode.BaseNodeViewHolder<MainTreeItemHolder.IconTreeItem> {
    private TextView tvValue;


    public MainTreeItemHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, IconTreeItem value) {


        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.customer_header_row, null, false);
        tvValue = (TextView) view.findViewById(R.id.header_text);
        tvValue.setText(value.text);

        return view;
    }


    public static class IconTreeItem {

        public String text;

        public IconTreeItem(String text) {

            this.text = text;
        }
    }
}
