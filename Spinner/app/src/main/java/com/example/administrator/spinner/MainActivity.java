package com.example.administrator.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String[] contriesStr={"广州","深圳","珠海","北京","重庆","123"};
    private TextView mytextview;
    private Spinner myspinner;
    private ArrayAdapter adapter;
    private Button ad_btn;
    private Button de_btn;
    private EditText editText;
    private List allCountries;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allCountries = new ArrayList();
        for (int i = 0; i < contriesStr.length; i++) {
            allCountries.add(contriesStr[i]);
        }
        ad_btn = (Button) findViewById(R.id.ad_btn);
        de_btn = (Button) findViewById(R.id.de_btn);
        editText = (EditText) findViewById(R.id.editText);
        mytextview = (TextView) findViewById(R.id.textview);
        myspinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contriesStr);
        adapter.setDropDownViewResource(R.layout.spinner);
        myspinner.setAdapter(adapter);

        ad_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String newCountry=editText.getText().toString();
                for(int i=0;i<adapter.getCount();i++)
                {
                    if(newCountry.equals(adapter.getItem(i)))
                    {
                        return;
                    }
                }
                if(!newCountry.equals(""))
                {
                    adapter.add(newCountry);
                    int position= adapter.getPosition(newCountry);
                    myspinner.setSelection(position);
                    editText.setText("");
                }
            }
        });
        de_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(myspinner.getSelectedItem()!=null)
            {
                adapter.remove(myspinner.getSelectedItem().toString());
                editText.setText("");
                if(adapter.getCount()==0){
                    mytextview.setText("");
                }
            }

            }
        });
        myspinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long agr3) {
            mytextview.setText(arg0.getSelectedItem().toString());
                //mytextview.setText("your choose the city is: "+contriesStr[arg2]);
                //arg0.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        /*animation= AnimationUtils.loadAnimation(this,R.anim.myanim);
        myspinner.setOnTouchListener(new Spinner.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(animation);
                view.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        myspinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }*/
}}
