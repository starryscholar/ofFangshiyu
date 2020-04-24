package com.example.kingchen.taskmoocchapter17;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    MyReceiver myReceiver;
    Button btn;
    String scale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        //注册一个广播
        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("android.intent.action.MyReceiver");
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(myReceiver,filter);


        //发送广播
       // Intent intent = new Intent("android.intent.action.MyReceiver");
    //    sendBroadcast(intent);

        btn = (Button)this.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MyReceiver");
                sendBroadcast(intent);
               scale = myReceiver.getPower();

                tipDialog(scale);
            }
        });

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }


    public void tipDialog(String  scale) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("系统提示");
        builder.setMessage("当前电量"+scale+"记得充电");
        builder.setCancelable(true);

        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"确认",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"取消",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"忽略",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Log.e(TAG,"对话框显示了");
            }
        });

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.e(TAG,"对话框消失了");
            }
        });

        dialog.show();
    }

}
