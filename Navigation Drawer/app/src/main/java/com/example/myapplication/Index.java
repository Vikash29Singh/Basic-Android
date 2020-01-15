package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Index extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    Animation ud, du;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

       /* line1 = (LinearLayout) findViewById(R.id.line1);
        line2 = (LinearLayout) findViewById(R.id.line2);
        ud = AnimationUtils.loadAnimation(this, R.anim.ud);
        du = AnimationUtils.loadAnimation(this, R.anim.du);
        line1.setAnimation(ud);
        line2.setAnimation(du);*/

        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);
        ud = AnimationUtils.loadAnimation(this, R.anim.ud);
        du = AnimationUtils.loadAnimation(this, R.anim.du);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        tv.startAnimation(ud);
        iv.startAnimation(du);
        final Intent i = new Intent(this, Login.class);
        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }
}
