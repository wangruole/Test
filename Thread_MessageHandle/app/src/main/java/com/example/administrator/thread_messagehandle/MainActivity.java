package com.example.administrator.thread_messagehandle;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    ProgressBar bar=null;
    Button start_btn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar=(ProgressBar)findViewById(R.id.bar);
        start_btn=(Button)findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new startButtonListener());
    }

    private class startButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            bar.setVisibility(View.VISIBLE);
            updataBarHandler.post(updataThread);
        }
    }
    Handler updataBarHandler=new Handler(){
        public void handleMessage(Message msg){
            bar.setProgress(msg.arg1);
            updataBarHandler.post(updataThread);
        }
    };
    Runnable updataThread=new Runnable() {
        int i=0;
        @Override
        public void run() {
                System.out.println("Begin Thread");
            i=i+10;
            Message msg=updataBarHandler.obtainMessage();
            msg.arg1=i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updataBarHandler.sendMessage(msg);
            if(i==100)
            {
                updataBarHandler.removeCallbacks(updataThread);
            }
        }
    };
}
