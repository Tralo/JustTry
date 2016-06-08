package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allwe.vv.R;


/**
 * 消息: 会话
 */

public class TabSessionFrag extends Fragment {

    public static TabSessionFrag newInstance(Bundle args){
        TabSessionFrag sessionFrag = new TabSessionFrag();

        if(args != null){
            sessionFrag.setArguments(args);
        }
        return sessionFrag;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_session, container, false);
        return contentView;
    }
}
