package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allwe.vv.R;


/**
 * 首页: 最热
 */

public class TabHotestFrag extends Fragment {

    public static TabHotestFrag newInstance(Bundle args){
        TabHotestFrag hotestFrag = new TabHotestFrag();
        if(args != null){
            hotestFrag.setArguments(args);
        }
        return hotestFrag;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_hotest, container, false);

        return contentView;
    }
}
