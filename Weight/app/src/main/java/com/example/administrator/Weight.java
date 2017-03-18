package com.example.administrator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.administrator.weight.R;

public class Weight extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.btn_calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et=(EditText)findViewById(R.id.et_height);
                double height=Double.parseDouble(et.getText().toString());
                RadioGroup rg=(RadioGroup)findViewById(R.id.rg_sex);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        String sex="";
                        if(checkedId== R.id.rb_male){
                            sex="M";
                        }else{
                            sex="F";
                        }
                    }
                });

                Intent intent =new Intent();
                intent.setClass(Weight.this,result.class);
                Bundle bundle =new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}