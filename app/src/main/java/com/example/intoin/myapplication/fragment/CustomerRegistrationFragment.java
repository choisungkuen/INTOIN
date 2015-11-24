package com.example.intoin.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.intoin.myapplication.R;

/**
 * Created by choeseong-geun on 15. 11. 23..
 */
public class CustomerRegistrationFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customer_registration, container, false);

        return v;
    }



    @Override
    public void onStart() {
        super.onStart();
    }
}
