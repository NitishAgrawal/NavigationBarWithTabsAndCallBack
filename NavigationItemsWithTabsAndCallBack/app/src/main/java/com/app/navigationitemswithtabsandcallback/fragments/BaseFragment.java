package com.app.navigationitemswithtabsandcallback.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.navigationitemswithtabsandcallback.activities.BaseActivity;
import com.app.navigationitemswithtabsandcallback.controller.FragmentSelectControl;

public abstract class BaseFragment extends Fragment {

    public BaseActivity mActivity;
    public FragmentSelectControl mCallback;
    public Resources resources;
    int _layout = -1;
    String _extraTag = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity		=	(BaseActivity) this.getActivity();
        resources = getResources();

        Bundle args = this.getArguments();
        if(args != null) {
            this._layout = args.getInt("sc_extra_layout");
            this._extraTag = args.getString("sc_extra_tag");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(_layout, container, false);

        initOnCreateView(view);
        return view;
    }

    public abstract void initOnCreateView(View v);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentSelectControl) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement Interface");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if(mCallback == null)
            mCallback = (FragmentSelectControl) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Interface");
        }
    }

}
