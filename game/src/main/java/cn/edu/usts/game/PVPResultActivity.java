package cn.edu.usts.game;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PVPResultActivity extends Activity {
    TextView textView ;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvpresult);
        init();
        Intent intent = this.getIntent();
        int result = intent.getIntExtra("result",0);

        if(result == 1) {
            textView.setText("P1 win！");
        }
        else if(result == 0){
            textView.setText("P2  win!");
        }
        else {
            textView.setText("Get even!");
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1  = new Intent(PVPResultActivity.this,MainActivity.class);
                PVPResultActivity.this.startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityCollectorUtil.finishAllActivity();

            }
        });
    }
    void init(){
        textView = this.findViewById(R.id.pvptvResult);
        btn1 = this.findViewById(R.id.pvpbtnPlayAgain);
        btn2 = this.findViewById(R.id.pvpbtnFinish);
    }
}
