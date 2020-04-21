package cn.edu.usts.game;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends Activity {
    TextView textView ;
    Button btn1,btn2;
    boolean mIsExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectorUtil.addActivity(this);
        setContentView(R.layout.activity_result);
        init();
        Intent intent = this.getIntent();
        int result = intent.getIntExtra("result",0);

        if(result == 1) {
            textView.setText("you win！");
        }
        else if(result == 0){
            textView.setText("you lose!");
        }
        else {
            textView.setText("get even!");
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1  = new Intent(ResultActivity.this,MainActivity.class);
                ResultActivity.this.startActivity(intent1);
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
        textView = this.findViewById(R.id.tvResult);
        btn1 = this.findViewById(R.id.btnPlayAgain);
        btn2 = this.findViewById(R.id.btnFinish);
    }

}
