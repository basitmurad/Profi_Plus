package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivitySignUpBinding;
import com.basit.profitplus.helper.HideKeyBoard;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private String email , password , cnic, name , city , number ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HideKeyBoard.hideKeyboard(SignUpActivity.this);
            }
        });
    }

    private void checkValidation() {

        if (binding.etName.getText().toString().isEmpty())
        {
            binding.etName.setError("Name is empty");
        }

        if (binding.etPassword.getText().toString().isEmpty())
        {
            binding.etPassword.setError("Password is empty");
        }
        else if (binding.etPassword.length()<8)
        {
            binding.etPassword.setError("Less the 8 character");

        }

        if (binding.etCnic.getText().toString().isEmpty())
        {
            binding.etCnic.setError("CNIC is empty");
        }

        if (binding.etCity.getText().toString().isEmpty())
        {
            binding.etCity.setError("City is empty");
        }

        if (binding.etNumber.getText().toString().isEmpty())
        {
            binding.etNumber.setError("Number is empty");
        }
        if (binding.etEmail.getText().toString().isEmpty())
        {
            binding.etNumber.setError("Email is empty");
        }


        else {
            name = binding.etName.getText().toString();
            email = binding.etEmail.getText().toString();
            password = binding.etPassword.getText().toString();
            cnic = binding.etCnic.getText().toString();
            city = binding.etCity.getText().toString();
            number = binding.etNumber.getText().toString();
        }
    }
}