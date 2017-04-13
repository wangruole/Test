package com.example.administrator.datepickerdialog;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private TextView showdate;
    private Button setdate;
    private int year,year_NC;
    private int month,month_NC;
    private int day,day_NC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showdate =(TextView)this.findViewById(R.id.showtime);
        setdate=(Button)this.findViewById(R.id.setdate);
        Calendar c=Calendar.getInstance(Locale.CHINA);
        Date mydate=new Date();
        c.setTime(mydate);
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        year_NC=c.get(Calendar.YEAR);
        month_NC=c.get(Calendar.MONTH);
        day_NC=c.get(Calendar.DAY_OF_MONTH);
        showdate.setText("当前日期是："+year+"-"+(month+1)+"-"+day);
         setdate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DatePickerDialog my_datepickerdialog=new DatePickerDialog(MainActivity.this,DateListener,year,month,day);
                 my_datepickerdialog.show();
             }
         });
    }
    private DatePickerDialog.OnDateSetListener DateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
            if(year1<year_NC || (year1==year_NC && month1<month_NC) || (year1==year_NC && month1==month_NC && day1<=day_NC)){
            year=year1;
            month=month1;
            day=day1;
            updateDate();
            }
            else{
                showdate.setText("设置日期失败！");
            }
        }
        private void updateDate(){
            showdate.setText("当前日期是："+year+"-"+(month+1)+"-"+day);
        }
    };
}
