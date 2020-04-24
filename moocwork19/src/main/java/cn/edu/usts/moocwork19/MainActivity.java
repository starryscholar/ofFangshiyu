package cn.edu.usts.moocwork19;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        final RemoteViews views = new RemoteViews(getPackageName(),R.layout.mynotification);//自定义的布局视图

        button = (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder mBuilder = new Notification.Builder(MainActivity.this);
                Resources res = MainActivity.this.getResources();
                Bitmap bmp = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);//获取Bitmap对象
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);
                mBuilder.setTicker("收到信息~") //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis()) //设置通知时间
                        .setSmallIcon(R.mipmap.ic_launcher) //设置小图标
                        .setLargeIcon(bmp) //设置大图标
                        .setDefaults(Notification.DEFAULT_VIBRATE) //设置默认振动器
                        .setAutoCancel(true) //设置点击后取消Notification
                        .setContentIntent(pIntent)//设置PendingIntent
                        .setContent(views); //设置自定义布局
                Notification notify1 = mBuilder.build();
                manager.notify(8,notify1);

            }
        });
    }
}
