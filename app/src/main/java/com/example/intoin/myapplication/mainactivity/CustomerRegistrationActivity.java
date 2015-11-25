package com.example.intoin.myapplication.mainactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.fragment.CustomerAgreementFragment;
import com.example.intoin.myapplication.fragment.CustomerCertificationFragment;
import com.example.intoin.myapplication.fragment.CustomerRegistrationFragment;
import com.example.intoin.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by choeseong-geun on 15. 11. 10..
 */
public class CustomerRegistrationActivity extends FragmentActivity{


    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_tab);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.custom_viewpager);
        setupViewPager(viewPager);



        tabLayout = (TabLayout) findViewById(R.id.custom_tab);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        TextView textView = (TextView)findViewById(R.id.text);
        Button button1 = (Button)findViewById(R.id.icon);

        Util.CustomActionBar(this, textView, "고객등록", button1);



    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CustomerAgreementFragment());
        adapter.addFrag(new CustomerCertificationFragment());
        adapter.addFrag(new CustomerRegistrationFragment());
        viewPager.setAdapter(adapter);
    }


    private void setupTabIcons() {



        tabLayout.getTabAt(0).setCustomView(R.layout.tab1);
        tabLayout.getTabAt(1).setCustomView(R.layout.tab2);
        tabLayout.getTabAt(2).setCustomView(R.layout.tab3);

    }



    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);

        }



    }


    public static class DummyFragment extends Fragment {


        public DummyFragment() {
        }

        @SuppressLint("ValidFragment")
        public DummyFragment(int color) {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dummy_fragment, container, false);

            final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);


            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);



            return view;
        }
    }








}
