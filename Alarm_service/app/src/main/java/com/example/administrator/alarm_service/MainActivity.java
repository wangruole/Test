package com.example.administrator.alarm_service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static MainActivity  appRef=null;
    private Button call_alarmbtn,exit_btn;
    boolean k=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appRef=this;
        setContentView(R.layout.activity_main);
        call_alarmbtn=(Button)findViewById(R.id.call_alarm);
        call_alarmbtn.setOnClickListener(this);
        exit_btn=(Button)findViewById(R.id.exit);
        exit_btn.setOnClickListener(this);
    }
    public static MainActivity getApp(){
        return appRef;
    }
    public void btEvent(String data){
        setTitle(data);
    }
    @Override
    public void onClick(View view) {
        if(view==call_alarmbtn){
            setTitle("Waiting...Alarm=5");
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            PendingIntent p_intent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
            Calendar calendar=Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.SECOND,3);
            AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),p_intent);

        }
        if(view==exit_btn){
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            PendingIntent p_intent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
            AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
            am.cancel(p_intent);
            finish();
        }
    }


}
