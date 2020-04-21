package cn.edu.usts.moocwork9;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends Activity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        listView = this.findViewById(R.id.lv);
        int imageId[] =  {R.mipmap.boy1,R.mipmap.boy2,R.mipmap.boy3,R.mipmap.girl1,R.mipmap.girl2,R.mipmap.girl3};
        String tvContent[] = {"boy1","boy2","boy3","girl1","girl2","girl3"};
        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<>();
        for(int i = 0;i<imageId.length;i++) {
            HashMap<String,Object> hashMap= new HashMap<String,Object>();
            hashMap.put("ImageID",imageId[i]);
            hashMap.put("TvContent",tvContent[i]);
            arrayList.add(hashMap);
        }
        String from[] = {"ImageID","TvContent"};
        int to[] = {R.id.iv,R.id.tv};

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,arrayList,R.layout.swipelayout,from,to);
        listView.setAdapter(simpleAdapter);
    }
}
