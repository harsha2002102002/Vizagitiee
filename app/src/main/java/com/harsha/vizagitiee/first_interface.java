package com.harsha.vizagitiee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class first_interface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_interface);
         CardView places = findViewById(R.id.card_places);
        RelativeLayout food = findViewById(R.id.food);
        RelativeLayout news = findViewById(R.id.news);
        RelativeLayout jobs = findViewById(R.id.jobs);
        ImageView image = findViewById(R.id.about);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent in = new Intent(first_interface.this,About.class);
startActivity(in);
            }
        });
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));


        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(first_interface.this,Places.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent in = new Intent(first_interface.this,Food.class);
startActivity(in);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(first_interface.this,News.class);
                startActivity(in);
            }
        });
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(first_interface.this,Jobs.class);
                startActivity(in);
            }
        });

    }
}