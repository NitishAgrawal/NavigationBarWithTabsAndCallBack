package com.app.navigationitemswithtabsandcallback.fragments.menu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.controller.FControll;
import com.app.navigationitemswithtabsandcallback.fragments.BaseFragment;

public class TabBaseFragment extends BaseFragment implements ChangeFragment {
    //public DashBoard mActivity;

    public TabBaseFragment currentFragment;
    /*Tab Implementation start*/
      /* Your Tab host */
    protected TabHost mTabHost;

    /*Tab Implementation Close*/

    /*Header start*/
    TextView title;
    ImageView back;
    /*Header end*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("print mActivity", "working");
       // mActivity		=	(DashBoard) this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_main_tab_fragment_layout, container, false);
        initOnCreateView(view);
        return view;
    }

    @Override
    public void initOnCreateView(View v) {
        startupTabImpliment(v);
        /*Header*/
        title = (TextView)v.findViewById(R.id.title);
        back = (ImageView)v.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.onMainScreenClicked(FControll.BackBtn);
            }
        });
    }

    private void startupTabImpliment(View v) {
        /*
         *  Navigation stacks for each tab gets created..
         *  tab identifier is used as key to get respective stack for each tab
         */

        initTabsViews(v);
    }

    private void initTabsViews(View v) {
        mTabHost                =   (TabHost)v.findViewById(android.R.id.tabhost);
        mTabHost.setOnTabChangedListener(getListner());
        mTabHost.setup();
        initializeTabs(v);
    }

    protected TabHost.OnTabChangeListener getListner() {
        return null;
    }


    public void setCurrentFrag(Fragment frag) {
        currentFragment = (TabBaseFragment)frag;
    }

     /*Tab Implementation Start*/
    protected View createTabView(String name) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tabs_icon, null);
        TextView tabName =   (TextView) view.findViewById(R.id.tabName);
        tabName.setText(name);
        return view;
    }

    public void initializeTabs(final View v){

    }

    /* Might be useful if we want to switch tab programmatically, from inside any of the fragment.*/
    public void setCurrentTab(int val){
        mTabHost.setCurrentTab(val);
    }


    @Override
    public void pushFragment(String superTag, String tag, Fragment fragment) {
        mActivity.pushFragments(superTag,tag,fragment);
    }



    /*
     *   Imagine if you wanted to get an image selected using ImagePicker intent to the fragment. Ofcourse I could have created a public function
     *  in that fragment, and called it from the activity. But couldn't resist myself.
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mActivity.stackMap.get(mActivity.superTag).get(mActivity.mCurrentTab).size() == 0){
            return;
        }

        ///*Now current fragment on screen gets onActivityResult callback..*//*
        mActivity.stackMap.get(mActivity.superTag).get(mActivity.mCurrentTab).lastElement().onActivityResult(requestCode, resultCode, data);
    }


    /*Tab Implementation end*/

}