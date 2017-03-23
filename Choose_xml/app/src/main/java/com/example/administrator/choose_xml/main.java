package com.example.administrator.choose_xml;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class main extends AppCompatActivity {
    RadioButton rb1=null;
    RadioButton rb2=null;
    RadioButton rb3=null;
    RadioButton rb4=null;
    RadioGroup rg=null;
    RadioButton currentrb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= (RadioGroup)findViewById(R.id.radioGroup);
        rb1=(RadioButton)findViewById(R.id.a);
        rb2=(RadioButton)findViewById(R.id.b);
        rb3=(RadioButton)findViewById(R.id.c);
        rb4=(RadioButton)findViewById(R.id.d);
        rb1.setChecked(true);
        Button btn1_sure=(Button)findViewById(R.id.sure);
        Button btn2_cancel=(Button)findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }
    class btn1_sure implements View.OnClickListener {

        @Override
        public void onClick(View v) {
           // if(currentrb.getText().equals("在")){
             //   setTitle("你选择的答案是：正确的！");
            //}else{
              //  setTitle("你选择的答案是：错误的！");
            //}
            String ans="";
            if(rb1.isChecked()){
                ans="在";
            }else if(rb2.isChecked()){
                ans="的";
            }else if(rb3.isChecked()){
                ans="上";
            }else if(rb4.isChecked()){
                ans="和";
            }
            Intent intent=new Intent();
            intent.setClass(main.this,other.class);
            Bundle bundle=new Bundle();
            bundle.putString("ans",ans);
            intent.putExtras(bundle);
            //main.this.startActivityForResult(intent,0);对应下面的if
            main.this.startActivity(intent);//对应下面的switch
        }
    }
    class btn2_cancel implements View.OnClickListener {

        @Override
        public void onClick(View v) {
           rg.clearCheck();
            setTitle("");
        }
    }
protected void onActivityResult(int requestCode,int resultCode,Intent data)
{
    super.onActivityResult(requestCode,resultCode,data);
   switch (resultCode){
       case RESULT_OK:
           Bundle bunde=data.getExtras();
           String ans=bunde.getString("ans");
           break;
        default:break;
    }
    //if(requestCode==0&&resultCode==0){
      //  Bundle bunde=data.getExtras();
       //String ans=bunde.getString("ans");
    //}
}
}
