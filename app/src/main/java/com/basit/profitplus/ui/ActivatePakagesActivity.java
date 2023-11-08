package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityActivatePakagesBinding;
import com.basit.profitplus.databinding.ActivityActiveBalanceBinding;

public class ActivatePakagesActivity extends AppCompatActivity {

    private ActivityActivatePakagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivatePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}