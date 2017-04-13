package com.example.administrator.actionbar_exp;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.sql.Date;

class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            ViewConfiguration mconfig= ViewConfiguration.get(this);
            Field menuKeyField;
            menuKeyField=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField!=null){
                menuKeyField.setAccessible(true);

                    menuKeyField.setBoolean(mconfig,false);
            }


        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_call:
                Intent intent =new Intent(Intent.ACTION_CALL,Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.action_msm:
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("10086", null, "10086", null, null);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
