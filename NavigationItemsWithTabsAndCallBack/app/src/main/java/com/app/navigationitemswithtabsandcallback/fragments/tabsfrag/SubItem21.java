package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;
import com.app.navigationitemswithtabsandcallback.util.Const;


public class SubItem21 extends SubBaseFragment {

    public SubItem21() {}

    public static SubItem21 create(TabBaseFragment tBase)
    {
        final Bundle args = new Bundle();
        args.putInt(Const.BaseFragmentData.EXTRA_DATA_LAYOUT, R.layout.sub_item21);
        final SubItem21 f = new SubItem21();
        f.setArguments(args);
        f.changeFragment = (ChangeFragment) tBase;
        f.tFragment = tBase;
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCallback.setCurrentFrag(SubItem21.this);
    }

    @Override
    public void initOnCreateView(View v) {

    }


}
