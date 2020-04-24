package com.example.kingchen.taskmoocchapter17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

/**
 * Created by King Chen on 2020/4/21.
 */

public class MyReceiver extends BroadcastReceiver {
String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override

    public void onReceive(Context context, Intent intent) {

        int level = intent.getIntExtra("level", 200);
        power = String.valueOf(level);



        //Toast.makeText(context,String.valueOf(level),Toast.LENGTH_SHORT).show();
    }


}
