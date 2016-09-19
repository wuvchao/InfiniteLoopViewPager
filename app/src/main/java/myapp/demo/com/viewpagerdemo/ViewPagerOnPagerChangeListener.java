package myapp.demo.com.viewpagerdemo;

import android.support.v4.view.ViewPager;

/**
 * Created by wuchao on 2016/9/19.
 */
public class ViewPagerOnPagerChangeListener implements ViewPager.OnPageChangeListener {

    PageChangerListener mListener;

    public void setPagerListener(PageChangerListener listener) {
        mListener = listener;
    }

    private int size;

    public void setListSize(int size) {
        this.size = size;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mListener.onPageSelected(position % size);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}