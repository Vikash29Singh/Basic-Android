package com.example.lab8_1847253;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.skyfishjy.library.RippleBackground;

public class Splash_screen extends AppCompatActivity {

    RippleBackground rippleBackground;
    private ImageView imageView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        rippleBackground = findViewById(R.id.ripple_bg);
        imageView = (ImageView)findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        Animation myanim1 = AnimationUtils.loadAnimation(this,R.anim.zoomout);

        imageView.setAnimation(myanim);
        imageView.setAnimation(myanim1);

        rippleBackground.startRippleAnimation();

        final Intent intent = new Intent(Splash_screen.this, MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }

}
