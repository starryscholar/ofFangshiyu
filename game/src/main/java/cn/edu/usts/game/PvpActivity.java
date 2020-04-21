package cn.edu.usts.game;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PvpActivity extends Activity {
    ImageView v1 ,v2;

    Person person1;
    Person person2;
    Judger judger;
    TextView tv1,tv2;
    ImageView img1,img2,img3,img4,img5,img6;
    int round;
    int p1Option = -1,p2Option = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        init();

        img1.setOnClickListener(new ImgListener());
        img2.setOnClickListener(new ImgListener());
        img3.setOnClickListener(new ImgListener());
        img4.setOnClickListener(new ImgListener());
        img5.setOnClickListener(new ImgListener());
        img6.setOnClickListener(new ImgListener());
    }
    void init(){

        v1 = this.findViewById(R.id.pvpimgv1);
        v2 = this.findViewById(R.id.pvpimgv3);

        person1 = new Person();
        person2 = new Person();
        judger = new Judger();
        tv1 = this.findViewById(R.id.pvptv1);
        tv2 = this.findViewById(R.id.pvptv2);
        img1 =  this.findViewById(R.id.pvpimg1);
        img2 =  this.findViewById(R.id.pvpimg2);
        img3 =  this.findViewById(R.id.pvpimg3);
        img4 = this.findViewById(R.id.pvpimg1_1);
        img5 = this.findViewById(R.id.pvpimg2_1);
        img6 = this.findViewById(R.id.pvpimg3_1);
        round = 0;
    }
    class ImgListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.pvpimg1:
                    choose(0);
                    break;
                case R.id.pvpimg2:
                    choose(1);
                    break;
                case R.id.pvpimg3:
                    choose(2);
                    break;
                case R.id.pvpimg1_1:
                    choose(3);
                    break;
                case R.id.pvpimg2_1:
                    choose(4);
                    break;
                case R.id.pvpimg3_1:
                    choose(5);
                    break;

            }
        }
    }
    void choose(int value){
        switch (value){
            case 0:
                v1.setImageResource(R.drawable.ps1);
                p1Option = 0;
                break;
            case 1:
                v1.setImageResource(R.drawable.ps2);
                p1Option = 1;
                break;
            case 2:
                v1.setImageResource(R.drawable.ps3);
                p1Option = 2;
                break;
            case 3:
                v2.setImageResource(R.drawable.rock);
                p2Option = 0;
                break;
            case 4:
                v2.setImageResource(R.drawable.scissors);
                p2Option = 1;
                break;
            case 5:
                v2.setImageResource(R.drawable.paper);
                p2Option = 2;
                break;
        }
        if(p1Option!=-1&&p2Option!=-1){
            judger.getPVPResult(p1Option,p2Option,person1,person2);
            tv1.setText(Integer.toString(person1.getScore()));
            tv2.setText(Integer.toString(person2.getScore()));
            round++;
            p1Option = -1;
            p2Option = -1;
        }



        if(round==5) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(PvpActivity.this,PVPResultActivity.class);
                    if(person1.getScore()>person2.getScore()){
                        intent.putExtra("result",1);// person1 win
                    }
                    else if(person1.getScore()<person2.getScore()){
                        intent.putExtra("result",0);// person2 win
                    }
                    else {
                        intent.putExtra("result",2);// even
                    }
                    PvpActivity.this.startActivity(intent);
                }
            }, 1000);//秒后执行Runnable中的run方法



        }
    }
}
