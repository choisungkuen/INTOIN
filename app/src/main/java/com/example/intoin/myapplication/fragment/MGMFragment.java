package com.example.intoin.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.mainactivity.MGMDeatailActivity;
import com.example.intoin.myapplication.util.SpacesItemDecoration;


/**
 * Created by choeseong-geun on 15. 11. 5..
 */
public class MGMFragment extends Fragment{

    RecyclerView mRecyclerView;
    Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mgm_frag, container, false);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public void onStart() {
        super.onStart();


        mRecyclerView = (RecyclerView)getView().findViewById(R.id.masonry_grid);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);
        glm.setSpanSizeLookup(new HeaderSpanSizeLookup(glm));
        mRecyclerView.setLayoutManager(glm);
        Adapter adapter = new Adapter(getActivity(),"MGM");
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(5));
        mRecyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity() , MGMDeatailActivity.class);
                startActivity(intent);


            }
        });

//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

//        mRecyclerView.setAdapter(adapter);
//        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
//        mRecyclerView.addItemDecoration(decoration);



    }

    class HeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        private final GridLayoutManager layoutManager;

        public HeaderSpanSizeLookup(GridLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        @Override
        public int getSpanSize(int position) {
            position = position == 0 ? layoutManager.getSpanCount() : 1;
            return position;
        }

    }



}
