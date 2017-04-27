package com.example.administrator.broadcast;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn=null;
    private final String nobody="Who.care.the.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new MybuttonListener());
    }
    class MybuttonListener implements View.OnClickListener{
        public void onClick(View v){
            Intent i=new Intent(nobody);
            i.putExtra("testIntent","111111111111");
        sendBroadcast(i);
        }
    }
}
