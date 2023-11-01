package com.basit.profitplus;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.basit.profitplus.ui.SignInActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.text);

        // Create an ObjectAnimator to move the TextView from left to right
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, 0f, 500f);
        animator.setDuration(1200); // Animation duration in milliseconds
        animator.setInterpolator(new LinearInterpolator()); // Linear animation
        animator.setRepeatCount(1); // Repeat the animation once

        // Start the animation
        animator.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//
//                YoYo.with(Techniques.SlideInRight)
//                        .duration(700)
//                        .repeat(1)
//                        .playOn(findViewById(R.id.text));
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
            }
        },1000);

       ;
    }
}