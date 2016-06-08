package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allwe.vv.R;

/**
 * 消息: 玩伴
 */

public class TabPartnerFrag extends Fragment {
    public static TabPartnerFrag newInstance(Bundle args){
        TabPartnerFrag partnerFrag = new TabPartnerFrag();

        if(args != null){
            partnerFrag.setArguments(args);
        }
        return partnerFrag;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_partner, container, false);
        return contentView;
    }


}
