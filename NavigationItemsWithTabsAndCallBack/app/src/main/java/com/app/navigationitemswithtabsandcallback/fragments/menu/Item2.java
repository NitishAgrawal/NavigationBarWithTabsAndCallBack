package com.app.navigationitemswithtabsandcallback.fragments.menu;

import android.app.Fragment;
import android.view.View;
import android.widget.TabHost;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.fragments.tabsfrag.SubBaseFragment;
import com.app.navigationitemswithtabsandcallback.fragments.tabsfrag.SubItem3;
import com.app.navigationitemswithtabsandcallback.fragments.tabsfrag.SubItem4;
import com.app.navigationitemswithtabsandcallback.util.Const;

public class Item2 extends TabBaseFragment {

    public SubBaseFragment currentFragment;

    @Override
    public void initOnCreateView(View v) {
        super.initOnCreateView(v);
        title.setText(resources.getString(R.string.Item2));
    }

    @Override
    protected TabHost.OnTabChangeListener getListner() {
        return listener;
    }

     @Override
    public void setCurrentFrag(Fragment frag) {
         currentFragment = (SubBaseFragment) frag;
    }

    /*Tab Implementation Start*/


    @Override
    public void initializeTabs(final View v){
           /* Setup your tab icons and content views.. Nothing special in this..*/
        TabHost.TabSpec spec    =   mTabHost.newTabSpec(Const.TAB_A);
        mTabHost.setCurrentTab(-3);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return v.findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(resources.getString(R.string.sub_item3)));
        mTabHost.addTab(spec);


        spec                    =   mTabHost.newTabSpec(Const.TAB_B);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return v.findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(resources.getString(R.string.sub_item4)));
        mTabHost.addTab(spec);
    }


    /*Comes here when user switch tab, or we do programmatically*/
    TabHost.OnTabChangeListener listener    =   new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {
        /*Set current tab..*/
            mActivity.mCurrentTab                     =   tabId;

            if(mActivity.stackMap.get(mActivity.superTag).get(tabId).size() == 0){
          /*
           *    First time this tab is selected. So add first fragment of that tab.
           *    Dont need animation, so that argument is false.
           *    We are adding a new fragment which is not present in stack. So add to stack is true.
           */
                if(tabId.equals(Const.TAB_A)){
                    mActivity.pushFragments(Const.ITEM2,tabId, SubItem3.create(Item2.this));
                }else if(tabId.equals(Const.TAB_B)){
                    mActivity.pushFragments(Const.ITEM2,tabId, SubItem4.create(Item2.this));
                }
            }else {
          /*
           *    We are switching tabs, and target tab is already has atleast one fragment.
           *    No need of animation, no need of stack pushing. Just show the target fragment
           */
                mActivity.pushFragments(Const.ITEM2,tabId, mActivity.stackMap.get(mActivity.superTag).get(tabId).lastElement());
            }
        }
    };

    /*Tab Implementation end*/
}

