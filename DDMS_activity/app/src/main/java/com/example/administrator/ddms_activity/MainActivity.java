package com.example.administrator.ddms_activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    static final String LIFT_TAG="LogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onCreate");
        Button btn=(Button)findViewById(R.id.btn);
        btn.setText("启动第二个Activity");
        btn.setOnClickListener(new ButtonOnclickListener());
    }
    class ButtonOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,DDMSActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
    protected void onDestroy(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onDestroy");
        super.onDestroy();
    }
    protected void onPause(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onPause");
        super.onPause();
    }
    protected void onRestart(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onReatart");
        super.onRestart();
    }
    protected void onResume(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onResume");
        super.onResume();
    }
    protected void onStart(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onStart");
        super.onStart();
    }
    protected void onStop(){
        Log.v(MainActivity.LIFT_TAG,"FirstAcvity---->onStop");
        super.onStop();
    }
}
