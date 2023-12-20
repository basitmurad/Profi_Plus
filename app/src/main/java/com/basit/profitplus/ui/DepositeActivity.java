package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityDepositeBinding;

public class DepositeActivity extends AppCompatActivity {

    private ActivityDepositeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDepositeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}