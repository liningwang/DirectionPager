package com.wangln.viewpagertest11;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class MyPagerHor extends ViewPager {
    float lastY;
    public MyPagerHor(Context context){
        super(context);
    }
    public MyPagerHor(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        Log.d("wang","onInterceptTouchEvent " + ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float currY = ev.getX();
                float change = currY - lastY;
                Log.d("wang","change " + change);
                if(Math.abs(change) > 50) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("wang","parent " + ev.getAction());
        return super.onTouchEvent(ev);
    }
}
