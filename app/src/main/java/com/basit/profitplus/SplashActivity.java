package com.basit.profitplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.basit.profitplus.databinding.ActivityMyInvitesBinding;
import com.basit.profitplus.databinding.ActivitySplashBinding;
import com.basit.profitplus.ui.BuyNewPackageActivity;
import com.basit.profitplus.ui.DashboardActivity;
import com.basit.profitplus.ui.SignInActivity;
import com.basit.profitplus.ui.SignUpActivity;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;

    private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        binding.textView.setAnimation(topAnim);
        binding.textView2.setAnimation(bottomAnim);

//
//        TextView textView = findViewById(R.id.text);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, View.AUTOFILL_HINT_NAME, 100f, 300f);
//        animator.setDuration(1200); // Animation duration in milliseconds
//        animator.setInterpolator(new LinearInterpolator()); // Linear animation
////        animator.setRepeatCount(); // Repeat the animation once
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(@NonNull Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(@NonNull Animator animation) {
//                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
//
//
//            }
//
//            @Override
//            public void onAnimationCancel(@NonNull Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(@NonNull Animator animation) {
//
//            }
//        });

        // Start the animation
//        animator.start();

        Handler handler = new Handler();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//
//                YoYo.with(Techniques.SlideInRight)
//                        .duration(700)
//                        .repeat(1)
//                        .playOn(findViewById(R.id.text));
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
            }
        },1400);

    }
}