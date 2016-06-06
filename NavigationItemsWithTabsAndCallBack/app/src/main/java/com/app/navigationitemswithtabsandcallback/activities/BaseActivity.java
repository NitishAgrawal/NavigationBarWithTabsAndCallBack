package com.app.navigationitemswithtabsandcallback.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.navigationitemswithtabsandcallback.R;
import com.app.navigationitemswithtabsandcallback.controller.FragmentSelectControl;

import java.util.HashMap;
import java.util.Stack;


public abstract class BaseActivity extends AppCompatActivity implements FragmentSelectControl {

    public Resources resources;
    public String superTag;
    public HashMap<String,HashMap<String,Stack<Fragment>>> stackMap;
    /*Save current tabs identifier in this..*/
    public String mCurrentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fram);
        resources = getResources();

    }

    public void callFragment(Fragment fragment, int id, Bundle bundle) {
        int size = stackMap.get(superTag).get(mCurrentTab).size();
        if(bundle != null)
            fragment.setArguments(bundle);
        FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        fTransaction.replace(id, fragment);
        fTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        int size = stackMap.get(superTag).get(mCurrentTab).size();
        if(size == 1){
            super.onBackPressed();
        }else{
            popFragments();
        }
       /* if(((SubBaseFragment)stackMap.get(superTag).get(mCurrentTab).lastElement()).onBackPressed() == false){
            *//*
            * top fragment in current tab doesn't handles back press, we can do our thing, which is
                    *
            * if current tab has only one fragment in stack, ie first fragment is showing for this tab.
                    *        finish the activity
            * else
            *        pop to previous fragment in stack for the same tab
                    *
            *//*
            if(stackMap.get(superTag).get(mCurrentTab).size() == 1){
                super.onBackPressed();  // or call finish..
            }else{
                popFragments();
            }
        }else{
            //do nothing.. fragment already handled back button press.
        }*/
    }

    public void popFragments(){
      /*
       *    Select the second last fragment in current tab's stack..
       *    which will be shown after the fragment transaction given below
       */
        int size = stackMap.get(superTag).get(mCurrentTab).size();
        Fragment fragment             =   stackMap.get(superTag).get(mCurrentTab).elementAt(size - 2);

      /*pop current fragment from stack.. */
        stackMap.get(superTag).get(mCurrentTab).pop();

      /* We have the target fragment in hand.. Just show it.. Show a standard navigation animation*/
        FragmentManager manager         =   getFragmentManager();
        FragmentTransaction ft            =   manager.beginTransaction();
        //ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        ft.replace(R.id.realtabcontent, fragment);
        ft.commit();
    }

    /*
    *      To add fragment to a tab.
    *  tag             ->  Tab identifier
    *  fragment        ->  Fragment to show, in tab identified by tag
    *  shouldAnimate   ->  should animate transaction. false when we switch tabs, or adding first fragment to a tab
    *                      true when when we are pushing more fragment into navigation stack.
    *  shouldAdd       ->  Should add to fragment navigation stack (mStacks.get(tag)). false when we are switching tabs (except for the first time)
    *                      true in all other cases.
    */
    public void pushFragments(String superTag,String tag, Fragment fragment){

        if(!isCurentFragment(superTag,tag,fragment))
            stackMap.get(superTag).get(tag).push(fragment);
        //int size = stackMap.get(superTag).get(mCurrentTab).size();
        FragmentManager manager         =   getFragmentManager();
        FragmentTransaction ft            =   manager.beginTransaction();
        /*if(shouldAnimate)
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);*/
        ft.replace(R.id.realtabcontent, fragment);
        ft.commit();
    }

    private boolean isCurentFragment(String superTag,String tag, Fragment fragment){
        try {
            int size = stackMap.get(superTag).get(mCurrentTab).size()-1;
            return (((Fragment)stackMap.get(superTag).get(tag).get(size) == fragment));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
