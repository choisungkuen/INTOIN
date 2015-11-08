package com.example.intoin.myapplication.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.intoin.myapplication.MainActivity;
import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.util.Util;


public class GuideFragment_4 extends Fragment {

    private int layout;
    private static final String page = "page";
    private Button go_bt;


    public static GuideFragment_4 newInstance(int layout) {
        GuideFragment_4 fragment = new GuideFragment_4();
        Bundle args = new Bundle();
        args.putInt(page,layout);
        fragment.setArguments(args);
        return fragment;
    }

    public GuideFragment_4() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layout = getArguments().getInt(page);
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        go_bt =  (Button)getView().findViewById(R.id.go_bt);
        go_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.Intent(getActivity(), MainActivity.class);

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.guide4_fragment, container, false);




        return v;
    }
}
