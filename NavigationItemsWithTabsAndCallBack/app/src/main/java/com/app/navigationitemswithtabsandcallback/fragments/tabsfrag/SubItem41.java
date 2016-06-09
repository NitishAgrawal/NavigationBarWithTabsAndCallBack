package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import android.os.Bundle;
import android.view.View;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;
import com.app.navigationitemswithtabsandcallback.util.Const;


public class SubItem41 extends SubBaseFragment {

    public SubItem41() {}

    public static SubItem41 create(TabBaseFragment tBase)
    {
        final Bundle args = new Bundle();
        args.putInt(Const.BaseFragmentData.EXTRA_DATA_LAYOUT, R.layout.sub_item41);
        final SubItem41 f = new SubItem41();
        f.setArguments(args);
        f.changeFragment = (ChangeFragment) tBase;
        f.tFragment = tBase;
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCallback.setCurrentFrag(SubItem41.this);
    }

    @Override
    public void initOnCreateView(View v) {

    }


}
