package cn.edu.usts.moocwork5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinPro,spinCity,spinDir ;
    ArrayAdapter proAdapter;
    ArrayAdapter cityAdapter;
    ArrayAdapter dirAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnertest);
        init();
        proAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.provinceArray,android.R.layout.simple_spinner_dropdown_item);
        spinPro.setAdapter(proAdapter);
        cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.cityOfJiangSu,android.R.layout.simple_spinner_dropdown_item);
        spinCity.setAdapter(cityAdapter);
        dirAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.dirOfNanJing,android.R.layout.simple_spinner_dropdown_item);
        spinDir.setAdapter(dirAdapter);
        spinPro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.cityOfJiangSu,android.R.layout.simple_spinner_dropdown_item);
                        spinCity.setAdapter(cityAdapter);
                        spinCity.setSelection(0,true);
                        break;
                    case 1:
                        cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.cityOfHeBei,android.R.layout.simple_spinner_dropdown_item);
                        spinCity.setAdapter(cityAdapter);
                        spinCity.setSelection(0,true);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        if(spinPro.getSelectedItemPosition()==0){
                            dirAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.dirOfNanJing,android.R.layout.simple_spinner_dropdown_item);
                            spinDir.setAdapter(dirAdapter);
                        }
                        if(spinPro.getSelectedItemPosition()==1){
                            dirAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.cityOfJiangSu,android.R.layout.simple_spinner_dropdown_item);
                            spinDir.setAdapter(dirAdapter);
                        }

                        break;
                    case 1:
                        if(spinPro.getSelectedItemPosition()==0){
                            dirAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.dirOfSuzhou,android.R.layout.simple_spinner_dropdown_item);
                            spinDir.setAdapter(dirAdapter);
                        }
                        if(spinPro.getSelectedItemPosition()==1){
                            dirAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.cityOfJiangSu,android.R.layout.simple_spinner_dropdown_item);
                            spinDir.setAdapter(dirAdapter);
                        }
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    void init(){
        spinPro = (Spinner) this.findViewById(R.id.spinPro);
        spinCity = (Spinner) this.findViewById(R.id.spinCity);
        spinDir = (Spinner) this.findViewById(R.id.spinDir);

    }
}
