package com.app.navigationitemswithtabsandcallback.controller;

import android.app.Fragment;

/**
 * Created by rails-dev on 5/10/15.
 */
public interface FragmentSelectControl {

    public void onMainScreenClicked(FControll position);

    public void setCurrentFrag(Fragment frag);
}
