package com.example.intoin.myapplication.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.example.intoin.myapplication.R;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by choeseong-geun on 15. 10. 29..
 */
public class ViewpagerActivity extends FragmentActivity {

    private List<Fragment> fragmentList;
    private Button go_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        setContentView(R.layout.viewpager_activity);

        // DEFAULT
        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);


        DemoPagerAdapter defaultPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager());

        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);

    }


}
