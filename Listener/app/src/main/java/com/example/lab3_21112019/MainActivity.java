package com.example.lab3_21112019;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button plus,minus,font,color,changebc;
    EditText name,password;
    RelativeLayout chnagecolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chnagecolor=(RelativeLayout)findViewById(R.id.chnagecolor);
        plus=(Button)findViewById(R.id.plus);

        minus=(Button)findViewById(R.id.minus);

        font=(Button)findViewById(R.id.font);

        color=(Button)findViewById(R.id.color);

        changebc=(Button)findViewById(R.id.changebc);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);



        changebc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                chnagecolor.setBackgroundColor(color);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setTextSize(0,name.getTextSize()+5);
                password.setTextSize(0,password.getTextSize()+5);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setTextSize(0,name.getTextSize()-5);
                password.setTextSize(0,password.getTextSize()-5);
            }
        });

        font.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {


                    name.setTypeface(Typeface.SANS_SERIF);
                    password.setTypeface(Typeface.SANS_SERIF);


            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                name.setBackgroundColor(color);
                password.setBackgroundColor(color);

            }
        });





    }
}
