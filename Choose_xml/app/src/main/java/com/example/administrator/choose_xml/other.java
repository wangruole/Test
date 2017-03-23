package com.example.administrator.choose_xml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class other extends AppCompatActivity {
    private Intent intent;
    private Bundle bunde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Bundle bunde =this.getIntent().getExtras();
        String ans=bunde.getString("ans");
        String sexText="";
        if(ans.equals("在")){
            sexText="正确";
        }else{
            sexText="错误";
        }
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("您选择的答案是:"+sexText);
        Button btn=(Button)findViewById(R.id.button_back);
        btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                other.this.setResult(RESULT_OK,intent);
                other.this.finish();
            }
        });
    }
}
