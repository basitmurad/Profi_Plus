package com.basit.profitplus;

import static android.app.ProgressDialog.show;

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
import android.widget.Toast;

import com.basit.profitplus.databinding.ActivityMyInvitesBinding;
import com.basit.profitplus.databinding.ActivitySplashBinding;
import com.basit.profitplus.ui.BuyNewPackageActivity;
import com.basit.profitplus.ui.DashboardActivity;
import com.basit.profitplus.ui.SignInActivity;
import com.basit.profitplus.ui.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;

    private ActivitySplashBinding binding;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        binding.textView.setAnimation(topAnim);
        binding.textView2.setAnimation(bottomAnim);


 currentUser= FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            // User is authenticated, navigate to DashboardActivity.
            navigateToDashboard();

            Toast.makeText(this, ""+currentUser.getEmail(), Toast.LENGTH_SHORT).show();

        } else {
            // User is not authenticated, navigate to SignUpActivity.
            navigateToSignUp();

        }

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



    }

    private void navigateToSignUp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
            }
        },1100);
    }

    private void navigateToDashboard() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
            }
        },1100);

    }
}