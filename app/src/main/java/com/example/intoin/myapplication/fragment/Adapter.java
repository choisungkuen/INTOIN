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

    int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};

    String[] nameList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};



    public Adapter(Context context){
        this.context = context;

    }


    public boolean isHeader(int position){
        return position == 0;
    }

    @Override
    public AdapterView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_custom, parent, false);
        AdapterView adapterView = new AdapterView(layoutView);
        return adapterView;
    }

    @Override
    public void onBindViewHolder(AdapterView holder, int position) {
        holder.image_1.setImageResource(imgList[position]);
        holder.image_2.setImageResource(imgList[position]);
        holder.image_3.setImageResource(imgList[position]);
        holder.textView.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }


    class AdapterView extends RecyclerView.ViewHolder {

        ImageView image_1;
        ImageView image_2;
        ImageView image_3;
        TextView textView;

        public AdapterView(View itemView) {
            super(itemView);

            image_1 = (ImageView) itemView.findViewById(R.id.image_1);
            image_2= (ImageView) itemView.findViewById(R.id.image_2);
            image_3 = (ImageView) itemView.findViewById(R.id.image_3);

            textView = (TextView) itemView.findViewById(R.id.img_name);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
