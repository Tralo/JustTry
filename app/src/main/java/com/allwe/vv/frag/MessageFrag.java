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

import com.allwe.vv.R;
import com.allwe.vv.aty.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 导航底部: 消息
 */

public class MessageFrag extends Fragment {

    @Bind(R.id.vv_tl_tabs)
    TabLayout vv_tl_tabs;
    @Bind(R.id.vv_vp)
    ViewPager vv_vp;

    public static MessageFrag newInstance(Bundle args){
        MessageFrag messageFrag = new MessageFrag();

        if(args != null){
            messageFrag.setArguments(args);
        }
        return messageFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取必要数据

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView =inflater.inflate(R.layout.frag_message, container, false);;
        ButterKnife.bind(this,contentView);
        initView();
        return contentView;

    }

    private void initView() {

        MessageAdapter adapter = new MessageAdapter(((MainActivity)getActivity()).getSupportFragmentManager());
        adapter.addFragment(TabSessionFrag.newInstance(null),getString(R.string.vv_session));
        adapter.addFragment(TabPartnerFrag.newInstance(null),getString(R.string.vv_partner));
        vv_vp.setAdapter(adapter);
        vv_tl_tabs.addTab(vv_tl_tabs.newTab().setText(getString(R.string.vv_session)));
        vv_tl_tabs.addTab(vv_tl_tabs.newTab().setText(getString(R.string.vv_partner)));

        vv_tl_tabs.setupWithViewPager(vv_vp);
    }


    static class MessageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MessageAdapter(FragmentManager fm) {
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
