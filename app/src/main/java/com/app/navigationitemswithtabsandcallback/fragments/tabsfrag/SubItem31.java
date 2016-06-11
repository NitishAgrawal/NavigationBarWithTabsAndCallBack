package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import android.os.Bundle;
import android.view.View;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;
import com.app.navigationitemswithtabsandcallback.util.Const;


public class SubItem31 extends SubBaseFragment {

    public SubItem31() {}

    public static SubItem31 create(TabBaseFragment tBase)
    {
        final Bundle args = new Bundle();
        args.putInt(Const.BaseFragmentData.EXTRA_DATA_LAYOUT, R.layout.sub_item31);
        final SubItem31 f = new SubItem31();
        f.setArguments(args);
        f.changeFragment = (ChangeFragment) tBase;
        f.tFragment = tBase;
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCallback.setCurrentFrag(SubItem31.this);
    }

    @Override
    public void initOnCreateView(View v) {

    }


}
