package cn.edu.usts.moocwork11;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewParentCompat;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<View> viewLists;
    PagerAdapter myAdapter;

    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        init();
        LayoutInflater li = getLayoutInflater();
        viewLists.add(li.inflate(R.layout.view1,null,false));
        viewLists.add(li.inflate(R.layout.view2,null,false));
        viewLists.add(li.inflate(R.layout.view3,null,false));
        viewLists.add(li.inflate(R.layout.view4,null,false));
        viewLists.add(li.inflate(R.layout.view5,null,false));
        myAdapter = new MyPageAdapter(viewLists);
        vp.setAdapter(myAdapter);
        mHandler.sendEmptyMessageDelayed(0, 3000);

    }
    public void init(){
        viewLists = new ArrayList<View>();


        vp = this.findViewById(R.id.vp);
    }
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int item = vp.getCurrentItem() + 1;
            vp.setCurrentItem(item);
            mHandler.sendEmptyMessageDelayed(0, 3000);
        }
    };


}
