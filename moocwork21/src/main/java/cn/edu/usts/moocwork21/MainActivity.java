package cn.edu.usts.moocwork21;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> arrayList_name = new ArrayList<>();
    ArrayList<String> arrayList_tel = new ArrayList<>();
    ArrayList<String> arrayList_address = new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        //数据库
        File file = this.getDatabasePath("database").getParentFile();
        if(file.exists()==false) {
            file.mkdir();
        }
        final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(file.toString()+File.separator+"testDB.db",MODE_PRIVATE,null);
        String createSQL ="create table contacters(name text,tel text,address text)";
        //下面一行第一次运行要取消注释，后面表存在，就加上注释
       // sqLiteDatabase.execSQL(createSQL);
        //____________________________________对item操作
        recyclerView = (RecyclerView) this.findViewById(R.id.rv);
        final String names[]={"Kate","HuangShang","DaDa","Xiao","Tian","SuSan"};
        final String tels[]={"18776232","13245765","2585432","16754321","13213213","12344321"};
        final String address[]={"Beijing","ShangDong","Shanghai","Jiangsu","Nanjing","NewYork"};
        for(int i = 0;i<names.length;i++) {
            arrayList_name.add(names[i]);
            arrayList_tel.add(tels[i]);
            arrayList_address.add(address[i]);
        }
        myAdapter = new MyAdapter(this,arrayList_name,arrayList_tel,arrayList_address);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                final View view = layoutInflater.inflate(R.layout.dialog_show,null);
                final EditText tvname =   view.findViewById(R.id.ed_name);
                final EditText tvtel = view.findViewById(R.id.ed_tel);
                final EditText tvaddress = view.findViewById(R.id.ed_address);

                final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
               // Toast.makeText(MainActivity.this,"你碰到我！"+position, Toast.LENGTH_SHORT).show();
                builder.setView(view).setPositiveButton("确定",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        myAdapter.setDatas(position,tvname.getText().toString(),tvtel.getText().toString(),tvaddress.getText().toString());
                        ContentValues values = new ContentValues();
                        values.put("name",tvname.getText().toString());
                        values.put("tel",tvtel.getText().toString());
                        values.put("address",tvaddress.getText().toString());
                        long id =sqLiteDatabase.insert("contacters",null,values);
                        if(id>0){
                            Toast.makeText(MainActivity.this,"插入数据库成功！"+values.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).setNegativeButton("取消",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
            }
        });
        //

    }
}
