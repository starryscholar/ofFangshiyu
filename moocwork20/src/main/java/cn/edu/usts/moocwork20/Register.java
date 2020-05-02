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

public class Register extends AppCompatActivity {
    Button btnregister,btnlogin;
    EditText name,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.register);
       init();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = Register.this.getSharedPreferences("myconfig", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("pwd",pwd.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                Register.this.startActivity(intent);
            }
        });
    }
    void init(){
        btnregister = (Button) this.findViewById(R.id.r_btnregister);
        btnlogin = (Button) this.findViewById(R.id.r_btnlogin);
        name = (EditText) this.findViewById(R.id.r_edtname);
        pwd = (EditText) this.findViewById(R.id.r_edtpwd);
    }
}
