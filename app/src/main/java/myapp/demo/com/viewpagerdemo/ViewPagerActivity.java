package myapp.demo.com.viewpagerdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements PageChangerListener {

    private ViewPager mViewpager;
    private LinearLayout mIndicationContainer;
    private ArrayList<Drawable> mList;
    ImageView[] mImages;//指示器容器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mList = new ArrayList<>();
        mList.add(getResources().getDrawable(R.drawable.pager_01));
        mList.add(getResources().getDrawable(R.drawable.pager_02));
        mList.add(getResources().getDrawable(R.drawable.pager_03));
        mList.add(getResources().getDrawable(R.drawable.pager_04));
        initView();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mIndicationContainer = (LinearLayout) findViewById(R.id.indicationContainer);
        initIndicationContainer();
        mViewpager.setAdapter(new ViewPagerAdapter(this, mList));
        ViewPagerOnPagerChangeListener viewPagerOnPagerChangeListener = new ViewPagerOnPagerChangeListener();
        viewPagerOnPagerChangeListener.setListSize(mList.size());
        viewPagerOnPagerChangeListener.setPagerListener(this);
        mViewpager.addOnPageChangeListener(viewPagerOnPagerChangeListener);
        mViewpager.setCurrentItem(mList.size() * 1000);//初始时页面就可以向前循环1000次
    }

    /**
     * 初始化指示器容器
     */
    private void initIndicationContainer() {
        mImages = new ImageView[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            ImageView imageView = new ImageView(this);
            mImages[i] = imageView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 0);
            mIndicationContainer.addView(mImages[i], layoutParams);
            if (i == 0)
                mImages[i].setImageResource(R.drawable.ptt_banner_dian_focus);
            else
                mImages[i].setImageResource(R.drawable.ptt_banner_dian_white);
        }
    }

    /**
     * 设置指示器背景
     * @param position
     */
    private void setIndicaterBg(int position) {
        for (int i = 0; i < mList.size(); i++) {
            if (i == position)
                mImages[i].setImageResource(R.drawable.ptt_banner_dian_focus);
            else
                mImages[i].setImageResource(R.drawable.ptt_banner_dian_white);
        }
    }

    @Override
    public void onPageSelected(int position) {
        setIndicaterBg(position);
    }
}
