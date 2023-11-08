package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityBuyNewPackageBinding;

public class BuyNewPackageActivity extends AppCompatActivity {


    private ActivityBuyNewPackageBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyNewPackageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




    }
}