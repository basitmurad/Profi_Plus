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
import android.view.animation.TranslateAnimation;
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

//        Animation animation = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, -1.0f,
//                Animation.RELATIVE_TO_SELF, 0
//        );
//        Animation animationBottom = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 8.0f,
//                Animation.RELATIVE_TO_SELF, 0);
//        animation.setDuration(2000); // 2 seconds duration
//        binding.textView.startAnimation(animation);
//        binding.textView2.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
            }
        },1100);

    }
}