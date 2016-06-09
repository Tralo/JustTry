package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import com.allwe.vv.R;
import com.allwe.vv.aty.MainActivity;
import com.allwe.vv.widget.segmentcontrol.SegmentControl;

/**
 * 导航底部: 首页
 */

public class MainpageFrag extends Fragment {

    private View contentView;

    private SegmentControl sc_control;

    private int currentIndex = 0;
    private List<Fragment> mFragments = new ArrayList<>();
    private Fragment currentFrag;


    public static MainpageFrag newInstance(Bundle args){
        MainpageFrag mainpageFrag = new MainpageFrag();


        if(args != null){
            mainpageFrag.setArguments(args);
        }
        return mainpageFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取必要数据
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView =inflater.inflate(R.layout.frag_mainpage, container, false);
        initView();

        changeTab(0);
        return contentView;

    }

    private void initView() {
        sc_control = (SegmentControl) contentView.findViewById(R.id.sc_control);
        sc_control.setText(getString(R.string.vv_leastest), getString(R.string.vv_hotest));
        mFragments.add(TabLeastestFrag.newInstance(null));
        mFragments.add(TabHotestFrag.newInstance(null));

        sc_control.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
//                Toast.makeText(getActivity(),"切换位置:  " + index , Toast.LENGTH_SHORT).show();
                changeTab(index);
            }
        });

    }

    private void changeTab(int index) {
        currentIndex = index;


        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        if (null != currentFrag) {
            ft.hide(currentFrag);
        }
        //先根据Tag从FragmentTransaction事物获取之前添加的Fragment
        Fragment fragment = getChildFragmentManager().findFragmentByTag(mFragments.get(currentIndex).getClass().getName());

        if (null == fragment) {
            //如fragment为空，则之前未添加此Fragment。便从集合中取出
            fragment = mFragments.get(index);
        }
        currentFrag = fragment;

        //判断此Fragment是否已经添加到FragmentTransaction事物中
        if (!fragment.isAdded()) {
            ft.add(R.id.fl_conent, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }


}
