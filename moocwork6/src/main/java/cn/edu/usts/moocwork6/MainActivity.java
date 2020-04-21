package cn.edu.usts.moocwork6;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends Activity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        tabHost.setup();
        TabHost.TabSpec tabMain = tabHost.newTabSpec("tabMain").setIndicator(getMenuItem(R.mipmap.home,"主页")).setContent(R.id.ll_red);
        tabHost.addTab(tabMain);
        TabHost.TabSpec tabClass = tabHost.newTabSpec("tabClass").setIndicator(getMenuItem(R.mipmap.category,"分类")).setContent(R.id.ll_blue);
        tabHost.addTab(tabClass);
        TabHost.TabSpec tabShop = tabHost.newTabSpec("tabShop").setIndicator(getMenuItem(R.mipmap.shopping_cart,"购物车")).setContent(R.id.ll_yellow);
        tabHost.addTab(tabShop);
        TabHost.TabSpec tabMine = tabHost.newTabSpec("tabMine").setIndicator(getMenuItem(R.mipmap.mine,"我的")).setContent(R.id.ll_green);
        tabHost.addTab(tabMine);
    }
    void initView(){
        tabHost = (TabHost) this.findViewById(R.id.mytabhost);

    }
    public View getMenuItem(int imgId, String string) {
        LinearLayout ll = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tabicon,null);
        ImageView imageView = (ImageView) ll.findViewById(R.id.img);
        imageView.setImageResource(imgId);
        TextView textView = (TextView) ll.findViewById(R.id.txt);
        textView.setText(string);
        return ll;
    }
}
