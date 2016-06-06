package com.app.navigationitemswithtabsandcallback.fragments.tabsfrag;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.ChangeFragment;
import com.app.navigationitemswithtabsandcallback.fragments.menu.TabBaseFragment;
import com.app.navigationitemswithtabsandcallback.util.Const;

public class SubItem1 extends SubBaseFragment {

    public SubItem1() {}

    public static SubItem1 create(TabBaseFragment tBase)
    {
        final Bundle args = new Bundle();
        args.putInt(Const.BaseFragmentData.EXTRA_DATA_LAYOUT, R.layout.sub_item1);
        final SubItem1 f = new SubItem1();
        f.setArguments(args);
        f.changeFragment = (ChangeFragment) tBase;
        f.tFragment = tBase;
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCallback.setCurrentFrag(SubItem1.this);
    }

    @Override
    public void initOnCreateView(View v) {
        TextView tv = (TextView) v.findViewById(R.id.subItme1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment.pushFragment(Const.ITEM1,Const.TAB_A,SubItem11.create(tFragment));
            }
        });
    }


}
