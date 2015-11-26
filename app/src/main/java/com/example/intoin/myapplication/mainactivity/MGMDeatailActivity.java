package com.example.intoin.myapplication.mainactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;
import com.example.intoin.myapplication.viewpager.DemoPagerAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by choeseong-geun on 15. 11. 10..
 */
public class MGMDeatailActivity extends FragmentActivity implements View.OnClickListener{

    Button mgm_callbt , mgm_okbt , link_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mgm_deatail);

        mgm_callbt = (Button)findViewById(R.id.mgm_callbt);
        mgm_okbt = (Button)findViewById(R.id.mgm_okbt);
        link_icon = (Button)findViewById(R.id.link_icon);

        mgm_callbt.setOnClickListener(this);
        mgm_okbt.setOnClickListener(this);
        link_icon.setOnClickListener(this);



        TextView textView = (TextView)findViewById(R.id.text);
        Button button1 = (Button)findViewById(R.id.icon);

        Util.DeatailActionBar(this, textView, "인천쉐르빌", button1);


        // DEFAULT
        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);


        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FCB86D")));
        mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#986EB0")));
        mPieChart.addPieSlice(new PieModel("Work", 35, Color.parseColor("#6CBB46")));
        mPieChart.addPieSlice(new PieModel("Eating", 9, Color.parseColor("#7FB8E5")));

        mPieChart.startAnimation();
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
            case R.id.mgm_okbt:
                Util.Intent(this , CustomerRegistrationActivity.class);
                break;

            case R.id.mgm_callbt:
                Util.Intent(this , InquiryActivity.class);
                break;

            case R.id.link_icon:
                Util.DeatailLinkPop(this);

                break;
        }
    }
}
