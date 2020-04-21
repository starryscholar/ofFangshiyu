package cn.edu.usts.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button buttonPvp,buttonPvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectorUtil.addActivity(this);
        setContentView(R.layout.activity_main);
        init();
        buttonPvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VersusActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        buttonPvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PvpActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


    }
    void init() {
        buttonPvp = this.findViewById(R.id.btnpvp);
        buttonPvc = this.findViewById(R.id.btnpvc);
    }
}
