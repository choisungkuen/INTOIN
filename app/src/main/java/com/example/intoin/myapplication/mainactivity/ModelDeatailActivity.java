package com.example.intoin.myapplication.mainactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;
import com.example.intoin.myapplication.viewpager.DemoPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by choeseong-geun on 15. 11. 10..
 */
public class ModelDeatailActivity extends FragmentActivity implements View.OnClickListener{

    private Button inquiry_Bt, link_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_deatail);

        TextView textView = (TextView)findViewById(R.id.text);
        Button button1 = (Button)findViewById(R.id.icon);
        link_icon = (Button)findViewById(R.id.link_icon);
        Util.DeatailActionBar(this, textView, "인천쉐르빌", button1);
        inquiry_Bt = (Button)findViewById(R.id.inquiry_Bt);
        inquiry_Bt.setOnClickListener(this);
        link_icon.setOnClickListener(this);

        // DEFAULT
        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);

//
//        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);
//
//        mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
//        mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#56B7F1")));
//        mPieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#CDA67F")));
//        mPieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#FED70E")));
//
//        mPieChart.startAnimation();
//
//        BarChart mBarChart = (BarChart) findViewById(R.id.barchart);
//
//        mBarChart.addBar(new BarModel(15, 0xFFFE6DA8));
//        mBarChart.addBar(new BarModel(25,  0xFF56B7F1));
//        mBarChart.addBar(new BarModel(35, 0xFFCDA67F));
//        mBarChart.addBar(new BarModel(9, 0xFFFED70E));


//        mBarChart.startAnimation();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.inquiry_Bt:
                Util.Intent(this , InquiryActivity.class);
                break;

            case R.id.link_icon:
                Util.DeatailLinkPop(this);

                break;
        }


    }
}
