package myapp.demo.com.viewpagerdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * ViewPagerAdapter
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    List<Drawable> list;

    public ViewPagerAdapter(Context context, List<Drawable> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_for_viewpager, null);
        ImageView imageContainer = (ImageView) view.findViewById(R.id.iv_container);
        imageContainer.setImageDrawable(list.get(position % list.size()));//取余%的方式，获得并设置循环的视图
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;//设置成大数，一般情况下不能到滑动到此边界
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
