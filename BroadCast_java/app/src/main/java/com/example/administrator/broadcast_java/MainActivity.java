package com.example.administrator.broadcast_java;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn=null;
    private Button btn2=null;
    private SMSReceiver smsReceiver=null;
    private static final String  Sms="android.provider.Telephony.SMS_RECEIVED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new btnListener());
        btn2.setOnClickListener(new btn2Listener());
    }

    private class btnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
           smsReceiver=new SMSReceiver();
            IntentFilter filter=new IntentFilter();
            filter.addAction(Sms);
            MainActivity.this.registerReceiver(smsReceiver,filter);
        }
    }
    private class btn2Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            MainActivity.this.unregisterReceiver(smsReceiver);
        }
    }
}
