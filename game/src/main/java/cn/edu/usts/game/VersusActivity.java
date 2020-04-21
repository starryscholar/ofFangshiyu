package cn.edu.usts.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class VersusActivity extends Activity {
    ImageView v1 ,v2;
    Computer computer ;
    Person person;
    Judger judger;
    TextView tv1,tv2;
    ImageView img1,img2,img3;

    int round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectorUtil.addActivity(this);
        setContentView(R.layout.activity_verse);
        init();

        img1.setOnClickListener(new ImgListener());
        img2.setOnClickListener(new ImgListener());
        img3.setOnClickListener(new ImgListener());

    }
    void init(){

        v1 = this.findViewById(R.id.imgv1);
        v2 = this.findViewById(R.id.imgv3);
        computer = new Computer();
        person = new Person();
        judger = new Judger();
        tv1 = this.findViewById(R.id.tv1);
        tv2 = this.findViewById(R.id.tv2);
        img1 =  this.findViewById(R.id.img1);
        img2 =  this.findViewById(R.id.img2);
        img3 =  this.findViewById(R.id.img3);
        round = 0;
    }
    class ImgListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            round++;
            switch (view.getId()) {
                case R.id.img1:
                    choose(0);
                    break;
                case R.id.img2:
                    choose(1);
                    break;
                case R.id.img3:
                    choose(2);
                    break;

            }
        }
    }
    void choose(int value){
        switch (value){
            case 0:
                v1.setImageResource(R.drawable.ps1);
                break;
            case 1:
                v1.setImageResource(R.drawable.ps2);
                break;
            case 2:
                v1.setImageResource(R.drawable.ps3);
                break;
        }
        int value2 = computer.play(0);
        switch (value2){
            case 0:
                v2.setImageResource(R.drawable.ps1);
                break;
            case 1:
                v2.setImageResource(R.drawable.ps2);
                break;
            case 2:
                v2.setImageResource(R.drawable.ps3);
                break;
        }
        judger.getPVCResult(value,value2,person,computer);

        tv1.setText(Integer.toString(person.getScore()));
        tv2.setText(Integer.toString(computer.getScore()));
        if(round==5) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(VersusActivity.this,ResultActivity.class);
                    if(person.getScore()>computer.getScore()){
                        intent.putExtra("result",1);// person win
                    }
                    else if(person.getScore()<computer.getScore()){
                        intent.putExtra("result",0);// person lose
                    }
                    else {
                        intent.putExtra("result",2);// even
                    }
                    VersusActivity.this.startActivity(intent);
                }
            }, 2000);//3秒后执行Runnable中的run方法



        }
    }

}
