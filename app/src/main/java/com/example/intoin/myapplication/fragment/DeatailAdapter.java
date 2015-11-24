package com.example.intoin.myapplication.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.viewpager.DemoPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by choeseong-geun on 15. 11. 5..
 */
public class DeatailAdapter extends RecyclerView.Adapter<DeatailAdapter.AdapterView> {

    private Context context;
    private static final int TYPE_HEADER = 1, TYPE_ITEM = 2;
    OnItemClickListener onItemClickListener;
    private String TYPE = null;
    DemoPagerAdapter defaultPagerAdapter;
    CircleIndicator defaultIndicator;

    int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};

    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};
    String[] header_nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};




    public DeatailAdapter(Context context ){
        this.context = context;



    }


    public boolean isHeader(int position){
        return position == 0;
    }

    @Override
    public AdapterView onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = null;


        switch (viewType){

            case TYPE_HEADER:
                layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deatail_header, parent, false);
                break;

            case TYPE_ITEM:

                layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deatail_content, parent, false);
                break;




        }
        return new AdapterView(layoutView);
    }

    @Override
    public void onBindViewHolder(AdapterView holder, int position) {

        switch (holder.getItemViewType()){
            case TYPE_HEADER:

                DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(((FragmentActivity)context).getSupportFragmentManager());
                holder.defaultViewpager.setAdapter(defaultPagerAdapter);
                holder.defaultIndicator.setViewPager(holder.defaultViewpager);


                break;

            case TYPE_ITEM:



        }

    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }


    class AdapterView extends RecyclerView.ViewHolder implements View.OnClickListener{

        ViewPager defaultViewpager;
        CircleIndicator defaultIndicator;



        public AdapterView(View itemView) {
            super(itemView);


            // DEFAULT
            defaultViewpager = (ViewPager) itemView.findViewById(R.id.viewpager_default);
            defaultIndicator = (CircleIndicator) itemView.findViewById(R.id.indicator_default);





        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(v,getAdapterPosition());
            }

        }


    }

    @Override
    public int getItemViewType(int position) {
        return position = position == 0 ? TYPE_HEADER :  TYPE_ITEM;
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void onItemClick(View view , int position){}




}
