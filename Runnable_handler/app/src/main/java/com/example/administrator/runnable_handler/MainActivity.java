package com.example.administrator.runnable_handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button start_btn=null;
    private Button end_btn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn=(Button)findViewById(R.id.start_btn);
        end_btn=(Button)findViewById(R.id.end_btn);
        start_btn.setOnClickListener(new StartButtonListener());
        end_btn.setOnClickListener(new endButtonListener());
    }
    Handler handler= new Handler();
    private class StartButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                   handler.post(updataThread);
        }
    }

    private class endButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            handler.removeCallbacks(updataThread);
        }
    }
    Runnable updataThread=new Runnable() {
        @Override
        public void run() {
            System.out.println("UpdataThread");
            Log.v("tag","UpdataThread");
            handler.postDelayed(updataThread,2000);
        }
    };
}
