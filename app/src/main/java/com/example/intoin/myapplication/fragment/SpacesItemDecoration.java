package com.example.intoin.myapplication.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by choeseong-geun on 15. 11. 5..
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public SpacesItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace/2;
        outRect.right = mSpace/2;
        outRect.bottom = mSpace/2;
        outRect.top = mSpace/2;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0){

        }
//            outRect.left = 0;
//        outRect.right = 0;
//        outRect.bottom = 0;
//        outRect.top = 0;
    }


}