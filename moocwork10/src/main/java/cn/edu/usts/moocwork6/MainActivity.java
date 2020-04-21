package cn.edu.usts.moocwork6;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends Activity {
    TabHost tabHost;
    ListView lv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        tabHost.setup();
        TabHost.TabSpec tabMain = tabHost.newTabSpec("tabMain").setIndicator(getMenuItem(R.mipmap.home,"首页")).setContent(R.id.ll_red);
        tabHost.addTab(tabMain);
        TabHost.TabSpec tabClass = tabHost.newTabSpec("tabClass").setIndicator(getMenuItem(R.mipmap.category,"分区")).setContent(R.id.ll_blue);
        tabHost.addTab(tabClass);
        TabHost.TabSpec tabShop = tabHost.newTabSpec("tabShop").setIndicator(getMenuItem(R.mipmap.shopping_cart,"消息")).setContent(R.id.ll_yellow);
        tabHost.addTab(tabShop);
        TabHost.TabSpec tabMine = tabHost.newTabSpec("tabMine").setIndicator(getMenuItem(R.mipmap.mine,"动态")).setContent(R.id.ll_green);
        tabHost.addTab(tabMine);
         String titles[]=  {"这些学校开学后，周六要上课，暑假也推迟","多国禁止农产品出口后粮价会涨吗？","深圳立法禁食狗肉：“现代人类文明的要求和体现”"};
        final String text[] =  {"返校复课后，除法定节假日调休以及中考高考等占用外，周六原则上正常上班上课。正式行课期间，每天下午可增加一课时，用于弥补推迟开学延误的教学时间。各学校可取消本学期半期考试、运动会、艺术节等活动。取消小学低段期末统考。小学高段期末考试原则上安排在原开学时间的第二十二周举行，中学期末考试安排在原开学时间的第二十三周举行。",
                "中新经纬客户端4月2日电（吴亦涵 实习生杜伦慧） 近期，不少国家纷纷宣布禁止农产品出口，引发消费者对于农产品价格上涨的担忧，以及投资者对于农业板块的关注。\n" +
                        "\n" +
                        "　　在业内人士看来，我国主粮对于国际市场的依赖性比较低，价格稳定有坚实的基础，因此消费者无需担心粮食安全，而从A股农业板块的上涨行情来看，更可能是一种短期的情绪炒作。",
                "深圳新闻网4月1日消息：3月31日，深圳市六届人大常委会第四十次会议通过了《深圳经济特区全面禁止食用野生动物条例》（以下简称《条例》），自2020年5月1日起施行。《条例》以白名单的形式明确规定：猪、牛、羊、驴、兔、鸡、鸭、鹅、鸽、鹌鹑可以吃，但猫狗禁止食用。\n" +
                        "\n" +
                        "　　记者从深圳市人大常委会法工委了解到，《条例》在列出上述的10种动物后，采用兜底条款的形式规定可食用陆生动物范围还包括“该目录所列其他以提供食用为目的饲养的家禽家畜”，将来如果国家相关目录作出修改，深圳的可食用动物范围也将随之相应调整。"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_dropdown_item_1line,titles);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(text[position]);
            }
        });
    }
    void initView(){
        tabHost = (TabHost) this.findViewById(R.id.mytabhost);
        lv = (ListView) this.findViewById(R.id.lv);
        tv = (TextView) this.findViewById(R.id.tv);

    }
    public View getMenuItem(int imgId, String string) {
        LinearLayout ll = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tabicon,null);

        TextView textView = (TextView) ll.findViewById(R.id.txt);
        textView.setText(string);
        return ll;
    }
}
