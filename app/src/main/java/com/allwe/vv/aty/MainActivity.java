package com.allwe.vv.aty;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


import com.allwe.vv.R;
import com.allwe.vv.adapter.FragmentsViewpagerAdapter;
import com.allwe.vv.frag.MainpageFrag;
import com.allwe.vv.frag.MessageFrag;
import com.allwe.vv.frag.MineFrag;
import com.allwe.vv.frag.FindFrag;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    public static final int TAB_MAINPAGE = 0;
    public static final int TAB_TOPIC = 1;
    public static final int TAB_MESSAGE = 2;
    public static final int TAB_MINE = 3;
    @Bind(R.id.vv_vp_content)
    public ViewPager vv_vp_content;
    BottomBar vv_bb_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        vv_bb_nav =  BottomBar.attach(this, savedInstanceState);
        vv_bb_nav.setMinimumHeight(60);
        initView();
        addPageChangeListener();
    }
    private void addPageChangeListener() {
        vv_vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case TAB_MAINPAGE:
                        vv_bb_nav.selectTabAtPosition(0,true);
                        break;
                    case TAB_TOPIC:
                        vv_bb_nav.selectTabAtPosition(1,true);
                        break;
                    case TAB_MESSAGE:
                        vv_bb_nav.selectTabAtPosition(2,true);
                        break;
                    case TAB_MINE:
                        vv_bb_nav.selectTabAtPosition(3,true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    /*@Bind(R.id.vv_rb_mainpage)
    public RadioButton vv_rb_mainpage;

    @Bind(R.id.vv_rb_topic)
    public RadioButton vv_rb_topic;

    @Bind(R.id.vv_rb_msg)
    public RadioButton vv_rb_msg;

    @Bind(R.id.vv_rb_mine)
    public RadioButton vv_rb_mine;

    @OnClick({R.id.vv_rb_mainpage, R.id.vv_rb_topic, R.id.vv_rb_msg, R.id.vv_rb_mine})
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.vv_rb_mainpage:
                vv_vp_content.setCurrentItem(TAB_MAINPAGE, true);
                break;
            case R.id.vv_rb_topic:
                vv_vp_content.setCurrentItem(TAB_TOPIC, true);
                break;
            case R.id.vv_rb_msg:
                vv_vp_content.setCurrentItem(TAB_MESSAGE, true);
                break;
            case R.id.vv_rb_mine:
                vv_vp_content.setCurrentItem(TAB_MINE, true );
                break;
        }
    }*/

    private void initView() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new MainpageFrag());
        fragments.add(new FindFrag());
        fragments.add(new MessageFrag());
        fragments.add(new MineFrag());
        vv_vp_content.setOffscreenPageLimit(0);
        FragmentsViewpagerAdapter adapter = new FragmentsViewpagerAdapter(getSupportFragmentManager(),vv_vp_content,fragments);



        vv_bb_nav.setItemsFromMenu(R.menu.vv_navigation_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
               switch (menuItemId){
                   case R.id.bb_menu_mainpage:
                       vv_vp_content.setCurrentItem(TAB_MAINPAGE, true);
                       break;
                   case R.id.bb_menu_topic:
                       vv_vp_content.setCurrentItem(TAB_TOPIC, true);
                       break;
                   case R.id.bb_menu_message:
                       vv_vp_content.setCurrentItem(TAB_MESSAGE, true);
                       break;
                   case R.id.bb_menu_mine:
                       vv_vp_content.setCurrentItem(TAB_MINE, true );
                       break;
               }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        vv_bb_nav.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        vv_bb_nav.mapColorForTab(1, 0xFF5D4037);
        vv_bb_nav.mapColorForTab(2, "#7B1FA2");
        vv_bb_nav.mapColorForTab(3, "#FF5252");


    }
}
