package cn.edu.usts.moocwork16;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.edu.usts.moocwork16.service.MyBindService;
import cn.edu.usts.moocwork16.service.MyService;

public class MainActivity extends AppCompatActivity {
    Button btnStart,btnStop,btnBind,btnUnbind;
    Intent intent,bindIntent;
    MyBindService.MyBinder myBinder;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           myBinder = (MyBindService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        init();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, MyService.class);
                MainActivity.this.startService(intent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.stopService(intent);
            }
        });
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindIntent = new Intent(MainActivity.this, MyBindService.class);
                bindService(bindIntent,serviceConnection,BIND_AUTO_CREATE);
            }
        });
        btnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(serviceConnection);
            }
        });
    }
    void init(){

        btnStart = (Button) this.findViewById(R.id.btnStart);
        btnStop = (Button) this.findViewById(R.id.btnStop);
        btnBind = (Button) this.findViewById(R.id.btnBind);
        btnUnbind = (Button) this.findViewById(R.id.btnUnbind);
    }
}
