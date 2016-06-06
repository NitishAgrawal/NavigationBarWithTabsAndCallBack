package com.app.navigationitemswithtabsandcallback.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.FControll;
import com.app.navigationitemswithtabsandcallback.fragments.menu.Item1;
import com.app.navigationitemswithtabsandcallback.fragments.menu.Item2;
import com.app.navigationitemswithtabsandcallback.util.Const;

import java.util.HashMap;
import java.util.Stack;

public class DashBoard extends BaseActivity implements View.OnClickListener
{

    /*Navigation Drawer start*/
    DrawerLayout drawer = null;
    NavigationView navigationView;
    LinearLayout stores,wishlists;
    /*Navigation Drawer close*/
    Fragment currentNavFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set Logedin
        setContentView(R.layout.one_dash_board);

        stackMap = new HashMap<String,HashMap<String, Stack<Fragment>>>();
        stackMap.put(Const.ITEM1,getMStacks());
        stackMap.put(Const.ITEM2,getMStacks());
        initNavigationDrawer();
        if (savedInstanceState == null) {
            superTag = Const.ITEM1;
            currentNavFrag = new Item1();
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_fram, currentNavFrag)
                    .commit();
        }
    }

    private HashMap<String, Stack<Fragment>> getMStacks(){
        HashMap<String, Stack<Fragment>> mStacks             =   new HashMap<String, Stack<Fragment>>();
        mStacks.put(Const.TAB_A, new Stack<Fragment>());
        mStacks.put(Const.TAB_B, new Stack<Fragment>());
        return mStacks;
    }

    private void initNavigationDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        drawer.closeDrawer(navigationView);

        //Navigation Header by code
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);

        //Set onClickOnHeaderOptions
        stores = (LinearLayout) header.findViewById(R.id.itme1);
        wishlists = (LinearLayout) header.findViewById(R.id.item2);

        stores.setOnClickListener(this);
        wishlists.setOnClickListener(this);
    }

    @Override
    public void onMainScreenClicked(FControll position) {
        switch (position){
            case BackBtn:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void setCurrentFrag(Fragment frag) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itme1:
                if(!(currentNavFrag instanceof Item1)) {
                    superTag = Const.ITEM1;
                    currentNavFrag = new Item1();
                    fireFragment(currentNavFrag);
                }
                break;
            case R.id.item2:
                if(!(currentNavFrag instanceof Item2)) {
                    superTag = Const.ITEM2;
                    currentNavFrag = new Item2();
                    fireFragment(currentNavFrag);
                }
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
    }


    private void fireFragment(Fragment fragment){
        callFragment(fragment,R.id.fragment_fram,null);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




}

