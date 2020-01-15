package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

public class Nointernet extends AppCompatActivity {
RippleBackground rippleBackground;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nointernet);
        /*iv = findViewById(R.id.iv);
        Animation myanimleft = AnimationUtils.loadAnimation(this,R.anim.rotate);
        iv.startAnimation(myanimleft);*/
        rippleBackground=findViewById(R.id.ripeffect);
        rippleBackground.startRippleAnimation();
    }
}
