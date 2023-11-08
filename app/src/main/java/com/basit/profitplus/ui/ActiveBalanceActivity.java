package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityActivePakagesBinding;

public class ActiveBalanceActivity extends AppCompatActivity {



    private ActivityActivePakagesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}