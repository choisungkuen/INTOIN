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
public class MainSearchCategoryRow extends TreeNode.BaseNodeViewHolder<MainSearchCategoryRow.GroupCategoryItem> {
    private TextView main_search_category_name_tv , main_search_category_count_tv;


    public MainSearchCategoryRow(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(final TreeNode node, GroupCategoryItem value) {


        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.main_search_catagory_row, null, false);
        main_search_category_name_tv = (TextView) view.findViewById(R.id.main_search_category_name_tv);
        main_search_category_count_tv = (TextView) view.findViewById(R.id.main_search_category_count_tv);


        main_search_category_count_tv.setText(value.count);
        main_search_category_name_tv.setText(value.text);

        return view;
    }


    public static class GroupCategoryItem {

        public String text;
        public String count;

        public GroupCategoryItem(String text, String count) {
            this.text = text;
            this.count = count;
        }
    }
}
