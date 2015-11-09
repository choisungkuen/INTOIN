package com.example.intoin.myapplication.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intoin.myapplication.R;

/**
 * Created by choeseong-geun on 15. 11. 5..
 */
public class Adapter extends RecyclerView.Adapter<Adapter.AdapterView> {

    private Context context;
    private static final int TYPE_HEADER = 1, TYPE_ITEM = 2;
    OnItemClickListener onItemClickListener;


    int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};

    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};
    String[] header_nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};




    public Adapter(Context context){
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
                layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_header, parent, false);
                break;

            case TYPE_ITEM:
               layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
                break;


        }
        return new AdapterView(layoutView);
    }

    @Override
    public void onBindViewHolder(AdapterView holder, int position) {

        switch (holder.getItemViewType()){
            case TYPE_HEADER:

                holder.header_image1.setImageResource(imgList[position]);
                holder.header_image2.setImageResource(imgList[position]);
                holder.header_image3.setImageResource(imgList[position]);
                holder.header_image4.setImageResource(imgList[position]);
                holder.header_image5.setImageResource(imgList[position]);
                holder.header_image6.setImageResource(imgList[position]);
                holder.header_image7.setImageResource(imgList[position]);
//        holder.image_2.setImageResource(imgList[position]);
//        holder.image_3.setImageResource(imgList[position]);
                holder.textView.setText(header_nameList[position]);



                break;

            case TYPE_ITEM:
                holder.image_1.setImageResource(imgList[position]);
//        holder.image_2.setImageResource(imgList[position]);
//        holder.image_3.setImageResource(imgList[position]);
                holder.textView.setText(nameList[position]);

                break;

        }

    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }


    class AdapterView extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image_1;
        ImageView image_2;
        ImageView image_3;
        TextView textView;

        ImageView header_image1;
        ImageView header_image2;
        ImageView header_image3;
        ImageView header_image4;
        ImageView header_image5;
        ImageView header_image6;
        ImageView header_image7;




        public AdapterView(View itemView) {
            super(itemView);

            image_1 = (ImageView) itemView.findViewById(R.id.image_1);
//            image_2= (ImageView) itemView.findViewById(R.id.image_2);
//            image_3 = (ImageView) itemView.findViewById(R.id.image_3);
            textView = (TextView) itemView.findViewById(R.id.img_name);
            header_image1 = (ImageView) itemView.findViewById(R.id.header_image1);
            header_image2 = (ImageView) itemView.findViewById(R.id.header_image2);
            header_image3 = (ImageView) itemView.findViewById(R.id.header_image3);
            header_image4 = (ImageView) itemView.findViewById(R.id.header_image4);
            header_image5 = (ImageView) itemView.findViewById(R.id.header_image5);
            header_image6 = (ImageView) itemView.findViewById(R.id.header_image6);
            header_image7 = (ImageView) itemView.findViewById(R.id.header_image7);
            itemView.setOnClickListener(this);



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
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void onItemClick(View view , int position){}




}
