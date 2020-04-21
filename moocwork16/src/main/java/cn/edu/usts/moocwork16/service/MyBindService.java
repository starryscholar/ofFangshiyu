package cn.edu.usts.moocwork16.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.widget.Toast;


public class MyBindService extends Service {
    boolean flag = true;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(getApplicationContext(),"绑定音乐",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag){
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
    }

    public MyBindService() {
    }
    MyBinder myBinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return myBinder;
    }
    public class MyBinder extends Binder{

    }
}
