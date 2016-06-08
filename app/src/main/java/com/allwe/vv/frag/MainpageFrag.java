package com.allwe.vv.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.allwe.vv.R;
import com.allwe.vv.aty.MainActivity;
import com.allwe.vv.widget.TabPageIndicator;

/**
 * 导航底部: 首页
 */

public class MainpageFrag extends Fragment {


    @Bind(R.id.ti_tab_indicator)
    TabPageIndicator ti_tab_indicator;
    @Bind(R.id.vv_vp)
    ViewPager vv_vp;

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
        View contentView =inflater.inflate(R.layout.frag_mainpage, container, false);
        ButterKnife.bind(this,contentView);
        initView();
        return contentView;

    }

    private void initView() {
        MainPageAdapter adapter = new MainPageAdapter(((MainActivity)getActivity()).getSupportFragmentManager());
        adapter.addFragment(TabHotestFrag.newInstance(null),getString(R.string.vv_leastest));
        adapter.addFragment(TabLeastestFrag.newInstance(null),getString(R.string.vv_hotest));
        vv_vp.setAdapter(adapter);
        ti_tab_indicator.setViewPager(vv_vp);

    }

    static class MainPageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MainPageAdapter(FragmentManager fm) {
            super(fm);
        }
        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
        @Override
        public int getCount() {
            return mFragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
