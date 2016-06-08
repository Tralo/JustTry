package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allwe.vv.R;


/**
 * 导航底部: 话题
 */
public class FindFrag extends Fragment {


    public static FindFrag newInstance(Bundle args){
        FindFrag findFrag = new FindFrag();

        if(args != null){
            findFrag.setArguments(args);
        }
        return findFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取必要数据


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_topic, container, false);;
        return contentView;
    }

}
