package com.harsha.vizagitiee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



        private static final int SPLASH_SCREEN_TIME_OUT = 2000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            LinearLayout layout = findViewById(R.id.layout);
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
            Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
            Animation scaleUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up);

layout.startAnimation(fadeIn);
layout.startAnimation(scaleUp);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(MainActivity.this,first_interface.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_SCREEN_TIME_OUT);
        }
}
