package com.example.intoin.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.intoin.myapplication.R;
import com.example.intoin.myapplication.fragment.holder.ButtonHolder;
import com.example.intoin.myapplication.fragment.holder.MainTreeItemHolder;
import com.example.intoin.myapplication.fragment.holder.PlaceHolderHolder;
import com.example.intoin.myapplication.fragment.holder.ProfileHolder;
import com.example.intoin.myapplication.fragment.holder.SocialViewHolder;
import com.example.intoin.myapplication.fragment.holder.SubHeaderHolder;
import com.example.intoin.myapplication.util.Util;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

/**
 * Created by choeseong-geun on 15. 11. 18..
 */
public class CustomerFragment extends Fragment implements View.OnClickListener{
    private AndroidTreeView tView;
    private Button customer_add_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cutomer_frag, null, false);
        final ViewGroup containerView = (ViewGroup) v.findViewById(R.id.container);
        final TreeNode root = TreeNode.root();







        TreeNode vip = new TreeNode(new MainTreeItemHolder.IconTreeItem("VIP")).setViewHolder(new ProfileHolder(getActivity()));
        TreeNode line = new TreeNode(new MainTreeItemHolder.IconTreeItem("LINE")).setViewHolder(new ProfileHolder(getActivity()));
        TreeNode group = new TreeNode(new MainTreeItemHolder.IconTreeItem("그룹")).setViewHolder(new ProfileHolder(getActivity()));
        TreeNode child_button = new TreeNode(new ButtonHolder.ButtonItem()).setViewHolder(new ButtonHolder(getActivity()));
        TreeNode child = new TreeNode(new MainTreeItemHolder.IconTreeItem("개인")).setViewHolder(new ProfileHolder(getActivity()));



//        데이터 셋

//        addTreeData(vip);
        addTreeData(line);
        addSubChilddData(group);
        addChildData(child);


        root.addChildren(vip, line , group ,child_button,child);



        tView = new AndroidTreeView(getActivity(), root);
        tView.setDefaultAnimation(true);
        tView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);

        tView.setDefaultNodeClickListener(new TreeNode.TreeNodeClickListener() {
            @Override
            public void onClick(TreeNode node, Object value) {

//                MainTreeItemHolder text = (MainTreeItemHolder) node.getViewHolder().getNodeItemsView().getTag();





//                Toast.makeText(getActivity(), node.getId() + "////"+value.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        containerView.addView(tView.getView());

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString("tState");
            if (!TextUtils.isEmpty(state)) {
                tView.restoreState(state);
            }
        }
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();



        customer_add_bt = (Button)getActivity().findViewById(R.id.customer_sub_toolbar).findViewById(R.id.customer_add_bt);
        customer_add_bt.setOnClickListener(this);


    }


    //Line vip 데이터 셋

    private void addTreeData(TreeNode profile) {


        TreeNode socialNetworks = new TreeNode(new MainTreeItemHolder.IconTreeItem("대행사")).setViewHolder(new SubHeaderHolder(getActivity()));
        TreeNode places = new TreeNode(new MainTreeItemHolder.IconTreeItem("본부장")).setViewHolder(new SubHeaderHolder(getActivity()));


        TreeNode facebook = new TreeNode(new SocialViewHolder.SocialItem()).setViewHolder(new SocialViewHolder(getActivity()));
        TreeNode linkedin =new TreeNode(new SocialViewHolder.SocialItem()).setViewHolder(new SocialViewHolder(getActivity()));
        TreeNode google = new TreeNode(new SocialViewHolder.SocialItem()).setViewHolder(new SocialViewHolder(getActivity()));
        TreeNode twitter = new TreeNode(new SocialViewHolder.SocialItem()).setViewHolder(new SocialViewHolder(getActivity()));

        TreeNode lake = new TreeNode(new PlaceHolderHolder.PlaceItem("010-1111-1234", null)).setViewHolder(new PlaceHolderHolder(getActivity()));
        TreeNode mountains = new TreeNode(new PlaceHolderHolder.PlaceItem("010-1111-1234", null)).setViewHolder(new PlaceHolderHolder(getActivity()));



        places.addChildren(lake, mountains);

        socialNetworks.addChildren(facebook, google, twitter, linkedin);
        profile.addChildren(socialNetworks, places );
    }


     //그룹 데이터 지정
    private void addSubChilddData(TreeNode profile) {
        TreeNode group = new TreeNode(new MainTreeItemHolder.IconTreeItem("SK")).setViewHolder(new SubHeaderHolder(getActivity()));
        TreeNode none_group = new TreeNode(new MainTreeItemHolder.IconTreeItem("미지정")).setViewHolder(new SubHeaderHolder(getActivity()));
        //미지정 데이터 ADD
        TreeNode child_row = new TreeNode(new PlaceHolderHolder.PlaceItem("김철수" , "1")).setViewHolder(new PlaceHolderHolder(getActivity()));
        TreeNode child_row_2 = new TreeNode(new PlaceHolderHolder.PlaceItem("이영희","1")).setViewHolder(new PlaceHolderHolder(getActivity()));

        none_group.addChildren(child_row, child_row_2);

        profile.addChildren(group, none_group );


    }

    //개인데이터

    private void addChildData(TreeNode profile) {


        TreeNode child_row = new TreeNode(new PlaceHolderHolder.PlaceItem("김철수" , "1")).setViewHolder(new PlaceHolderHolder(getActivity()));
        TreeNode child_row_2 = new TreeNode(new PlaceHolderHolder.PlaceItem("이영희","1")).setViewHolder(new PlaceHolderHolder(getActivity()));


        profile.addChildren(child_row, child_row_2);


    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.customer_add_bt:
                Util.CustomerAddePop(getActivity(), getActivity());
                break;
        }
    }
}
