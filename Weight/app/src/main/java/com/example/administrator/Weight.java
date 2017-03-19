package com.example.administrator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.administrator.weight.R;


public class Weight extends Activity {

    public static String sex = "M";
    private String str_height;
    private EditText et;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.btn_calculate);
        et = (EditText) findViewById(R.id.et_height);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                RadioGroup rg = (RadioGroup) findViewById(R.id.rg_sex);
                str_height = et.getText().toString();
                if ("".equals(str_height)) {
                    Toast.makeText(Weight.this, "体重不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                double height = Double.parseDouble(str_height);
                rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                        // TODO Auto-generated method stub
                        if (checkedId == R.id.rb_male) {
                            sex = "M";
                        } else {
                            sex = "F";
                        }
                    }
                });
                Intent intent = new Intent();
                intent.setClass(Weight.this, result.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putString("sex", sex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}