package com.wangln.viewpagertest11;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyPager mViewPager;
    private MyPagerHor viewPager;
    private int[] mImgIds = new int[] { R.drawable.a,
            R.drawable.b, R.drawable.c };
    private List<ImageView> mImageViews = new ArrayList<ImageView>();
    private List<MyPager> pagers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initData();
        viewPager = (MyPagerHor) findViewById(R.id.vp1);

        viewPager.setOffscreenPageLimit(5);
//        viewPager.setPageMargin(8);
        // Disable clip to padding
        viewPager.setClipToPadding(false);
// set padding manually, the more you set the padding the more you see of prev & next page
        viewPager.setPadding(80, 0, 80, 0);
// sets a margin b/w individual pages to ensure that there is a gap b/w them
        viewPager.setPageMargin(10);
//        ViewGroup.LayoutParams layoutParams = mViewPager.getLayoutParams();
//        layoutParams.width = 568;
//        viewPager.setLayoutParams(layoutParams);
        viewPager.setAdapter(adapter1);
        viewPager.setCurrentItem(1);
    }
    PagerAdapter adapter1 = new PagerAdapter()
    {
        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(pagers.get(position));
            return pagers.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object)
        {
            container.removeView(pagers.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public int getCount()
        {
            return pagers.size();
        }
    };
    PagerAdapter adapter = new PagerAdapter()
    {
        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(mImageViews.get(position));
            return mImageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
        Object object)
        {
            container.removeView(mImageViews.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public int getCount()
        {
            return mImgIds.length;
        }
    };
    private void initData()
    {
        for (int imgId : mImgIds)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(100,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundResource(imgId);
            mImageViews.add(imageView);
        }

        for (int i=0;i<5;i++)
        {
            MyPager pager = new MyPager(this);
            pager.setPageTransformer(true,new VerticalPageTransformer());
            pager.setAdapter(adapter);
            pager.setOffscreenPageLimit(3);
            pagers.add(pager);
        }
    }


}
