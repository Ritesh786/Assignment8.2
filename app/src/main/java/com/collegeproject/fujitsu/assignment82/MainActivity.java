package com.collegeproject.fujitsu.assignment82;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText mname, mage, mphone, mcity;
    Button msavebtn, mshowbtn;
    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String AGE = "ageKey";
    public static final String PHONE = "phoneKey";
    public static final String CITY = "cityKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mname = (EditText) findViewById(R.id.name_txt);
        mage = (EditText) findViewById(R.id.age_txt);
        mphone = (EditText) findViewById(R.id.phone_txt);
        mcity = (EditText) findViewById(R.id.city_txt);

        msavebtn = (Button) findViewById(R.id.uploadnews_btn);
        mshowbtn = (Button) findViewById(R.id.show_btn);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        msavebtn.setOnClickListener(this);
        mshowbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String n = mname.getText().toString();
        String ag = mage.getText().toString();
        String ph = mphone.getText().toString();
        String ci = mcity.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();


        switch (v.getId()) {

            case R.id.uploadnews_btn:




                editor.putString(Name, n);
                editor.putString(AGE, ag);
                editor.putString(PHONE, ph);
                editor.putString(CITY, ci);
                editor.commit();

                Toast.makeText(MainActivity.this, "SAVE", Toast.LENGTH_LONG).show();

                break;

            case R.id.show_btn:

                Toast.makeText(MainActivity.this,"Name ="+n, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"Age ="+ag, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"Phone ="+ph, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"City ="+ci, Toast.LENGTH_LONG).show();


                break;


        }
    }

}