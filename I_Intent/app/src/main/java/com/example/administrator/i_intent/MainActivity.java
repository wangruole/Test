package com.example.administrator.i_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn=(Button)findViewById(R.id.callBtn);
        final EditText et=(EditText)findViewById(R.id.phoneNum);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum=et.getText().toString();
                if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNum)){
                    Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+phoneNum));
                    startActivity(i);
                }else
                {
                    Toast.makeText(MainActivity.this, "你输入的号码不正确，请重新输入！", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
