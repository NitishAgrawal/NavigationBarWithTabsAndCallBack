package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;
import com.app.navigationitemswithtabsandcallback.util.Const;


public class SubItem3 extends SubBaseFragment {

    public SubItem3() {}

    public static SubItem3 create(TabBaseFragment tBase)
    {
        final Bundle args = new Bundle();
        args.putInt(Const.BaseFragmentData.EXTRA_DATA_LAYOUT, R.layout.sub_item3);
        final SubItem3 f = new SubItem3();
        f.setArguments(args);
        f.changeFragment = (ChangeFragment) tBase;
        f.tFragment = tBase;
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCallback.setCurrentFrag(SubItem3.this);
    }
    @Override
    public void initOnCreateView(View v) {
        TextView tv = (TextView) v.findViewById(R.id.subItme3);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment.pushFragment(Const.ITEM2,Const.TAB_A,SubItem31.create(tFragment));
            }
        });
    }


}
