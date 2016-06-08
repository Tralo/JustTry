package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.allwe.vv.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 首页: 最新
 */

public class TabLeastestFrag extends Fragment {

    @Bind(R.id.rlv_leastest_content)
    public RecyclerView rlv_leastest_content;


    @Bind(R.id.pb_show_progress)
    public ProgressBar pb_show_progress;



    public static TabLeastestFrag newInstance(Bundle args){
        TabLeastestFrag leastestFrag = new TabLeastestFrag();

        if(args != null){
            leastestFrag.setArguments(args);
        }
        return leastestFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_leastest, container, false);
        ButterKnife.bind(this,contentView);

        return contentView;
    }
}
