package cn.edu.usts.moocwork11;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 11616 on 2020/4/8.
 */

public class MyPageAdapter extends PagerAdapter {
    private ArrayList<View> viewLists;
    public MyPageAdapter() {
    }
    public MyPageAdapter(ArrayList<View> viewArrayLists) {
        super();
        this.viewLists=viewArrayLists;
    }
    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }
}
