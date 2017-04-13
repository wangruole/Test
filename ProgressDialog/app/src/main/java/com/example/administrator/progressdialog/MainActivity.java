package com.example.administrator.progressdialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar firstBar=null;
    private ProgressBar secondBar=null;
    private Button button=null;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBar =(ProgressBar)findViewById(R.id.firstBar);
        secondBar=(ProgressBar)findViewById(R.id.secondBar);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(i==0){
                firstBar.setVisibility(View.VISIBLE);
                secondBar.setVisibility(View.VISIBLE);

            }else if(i<secondBar.getMax()){
                secondBar.setProgress(i);
                firstBar.setProgress(i+10);
            }else{
                firstBar.setVisibility(View.GONE);
                secondBar.setVisibility(View.GONE);
            }
            i=i+10;
        }
    }
}
