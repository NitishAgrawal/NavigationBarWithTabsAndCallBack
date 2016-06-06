package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.BaseFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;

public abstract class SubBaseFragment extends BaseFragment {

    ChangeFragment changeFragment;
    TabBaseFragment tFragment;

    public boolean onBackPressed(){
        return false;
    }

}
