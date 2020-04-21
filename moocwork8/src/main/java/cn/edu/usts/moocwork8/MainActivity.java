package cn.edu.usts.moocwork8;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    HorizontalScrollView sv ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        LayoutInflater layoutInflater = LayoutInflater.from(this.getApplicationContext());
        sv = (HorizontalScrollView) layoutInflater.inflate(R.layout.scrollview,null);
        ll = this.findViewById(R.id.ll);
        ll.addView(sv);

    }
}
