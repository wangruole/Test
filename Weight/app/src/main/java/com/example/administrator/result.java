package com.example.administrator;



import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.weight.R;

public class result extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Bundle bunde =this.getIntent().getExtras();
        String sex=bunde.getString("sex");
        double height=bunde.getDouble("height");
        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }
        double weight=this.getWeight(sex,height);
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("你是一位"+sexText+"\n你的身高是"+height+"公分\n你的标准体重是"+weight+"公斤");
    }
    private double getWeight(String sex,double height){
        double weight=0;
        if(sex.equals("M")){
            weight=(height-80)*0.7;
        }else{
            weight=(height-70)*0.6;
        }
        return weight;
    }
}