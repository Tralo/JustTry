package com.allwe.vv.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止ViewPager左右滑动
 */
public class ContainerViewPager extends ViewPager {


    public ContainerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return true;
    }
}
