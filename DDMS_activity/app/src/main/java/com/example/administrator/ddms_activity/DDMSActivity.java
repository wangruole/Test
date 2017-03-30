package com.example.administrator.ddms_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DDMSActivity extends AppCompatActivity {
    static final String LIFT_TAG="LogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onCreate");
        super.onCreate(savedInstanceState);

    }
    protected void onDestroy(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onDestroy");
        super.onDestroy();
    }
    protected void onPause(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onPause");
        super.onPause();
    }
    protected void onRestart(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onReatart");
        super.onRestart();
    }
    protected void onResume(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onResume");
        super.onResume();
    }
    protected void onStart(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onStart");
        super.onStart();
    }
    protected void onStop(){
        Log.v(MainActivity.LIFT_TAG,"SecondAcvity---->onStop");
        super.onStop();
    }
}
