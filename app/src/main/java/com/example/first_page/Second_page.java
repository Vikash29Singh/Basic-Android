package com.example.first_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Second_page extends AppCompatActivity {
    TextView tv;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        tv=(TextView)findViewById(R.id.tv);


        name = getIntent().getExtras().getString("Name");
        tv.setTextSize(35);
        tv.setText(name);
        Toast toast= (Toast) Toast.makeText(getApplicationContext(),  name,Toast.LENGTH_SHORT);
        toast.show();
        tv.setText(name);


    }
}
