package com.wangln.viewpagertest11;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class MyPager extends ViewPager {
    public MyPager(Context context){
        super(context);
    }
    public MyPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);
        return ev;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("wang","touch " + ev.getAction());
        return super.onTouchEvent(swapXY(ev));
    }
}
