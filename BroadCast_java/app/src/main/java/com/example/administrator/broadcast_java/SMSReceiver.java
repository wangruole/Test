package com.example.administrator.broadcast_java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class SMSReceiver extends BroadcastReceiver{
    private static final String TAG="onReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"onRceiver->running");
        Bundle bundle=intent.getExtras();
        Object[] myObjpdus=(Object[])bundle.get("pdus");
        SmsMessage[] messages= new SmsMessage[myObjpdus.length];
        System.out.println(messages.length);
        for(int i=0;i<myObjpdus.length;i++){
            messages[i]=SmsMessage.createFromPdu((byte[])myObjpdus[i]);
            System.out.println(messages[i].getDisplayMessageBody());
        }
    }
}
