package cn.edu.usts.moocwork20;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin,btnreister;
    EditText edtname,edtpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_login);
        init();
        btnreister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                MainActivity.this.startActivity(intent  );
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("myconfig", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("name","admin");
                String pwd = sharedPreferences.getString("pwd","admin");
                if(name.equals(edtname.getText().toString())&&pwd.equals(edtpwd.getText().toString())){
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    void init () {
        btnlogin = (Button) this.findViewById(R.id.main_btnlogin);
        btnreister = (Button) this.findViewById(R.id.main_btnregister);
        edtname = (EditText) this.findViewById(R.id.main_edtname);
        edtpwd = (EditText) this.findViewById(R.id.main_edtpwd);
    }
}
