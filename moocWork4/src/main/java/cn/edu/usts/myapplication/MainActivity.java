package cn.edu.usts.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        MyListener myL = new MyListener();
        img1.setOnTouchListener(myL);
        img2.setOnTouchListener(myL);
        img3.setOnTouchListener(myL);
        img4.setOnTouchListener(myL);
    }
    void init(){
        img1 = (ImageView) this.findViewById(R.id.Img1);
        img2 = (ImageView) this.findViewById(R.id.Img2);
        img3 = (ImageView) this.findViewById(R.id.Img3);
        img4 = (ImageView) this.findViewById(R.id.Img4);
    }
    class MyListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (view.getId()){
                case R.id.Img1:
                    Toast.makeText(getApplicationContext(),"你选择了首页",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Img2:
                    Toast.makeText(getApplicationContext(),"你选择了目录",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Img3:
                    Toast.makeText(getApplicationContext(),"你选择了消息",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Img4:
                    Toast.makeText(getApplicationContext(),"你选择了设置",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }
    }
}
