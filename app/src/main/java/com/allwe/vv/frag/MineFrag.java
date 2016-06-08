package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allwe.vv.R;

/**
 * 导航底部: 我的
 */

public class MineFrag extends Fragment {

    public static MineFrag newInstance(Bundle args){
        MineFrag mineFrag = new MineFrag();

        if(args != null){
            mineFrag.setArguments(args);
        }
        return mineFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取必要数据

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_mine, container, false);;
        return contentView;
    }
}
