package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private String email , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkValidation();

            }
        });
    }

    private void checkValidation() {
        if (binding.etEmail.getText().toString().isEmpty())
        {
//            Toast.makeText(SignInActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();

            binding.etEmail.setError("Enter a valid email");
        }
          if (binding.etPassword.getText().toString().isEmpty())
        {

            binding.etPassword.setError("Enter a valid password");

//            Toast.makeText(SignInActivity.this, "Enter Passeord", Toast.LENGTH_SHORT).show();
        }

        else {

            email = binding.etEmail.getText().toString();
            password = binding.etPassword.getText().toString();

            startActivity(new Intent(SignInActivity.this,DashboardActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
    }
}