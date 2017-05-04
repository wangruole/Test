package com.example.administrator.alarm_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class NotifyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate(){
        MainActivity app=MainActivity.getApp();
        app.btEvent("from NotifyService");
        Toast.makeText(this,"系统自带的Service",Toast.LENGTH_LONG).show();
    }
}
