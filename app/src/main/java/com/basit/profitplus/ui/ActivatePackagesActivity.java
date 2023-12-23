package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.basit.profitplus.adapters.PackageDetailsAdapter;
import com.basit.profitplus.databinding.ActivityActivatePakagesBinding;
import com.basit.profitplus.models.PackagesDetails;

import java.util.ArrayList;

public class ActivatePackagesActivity extends AppCompatActivity {

    private ActivityActivatePakagesBinding binding;
    private ArrayList<PackagesDetails> packagesDetailsArrayList ;

    private PackageDetailsAdapter packageDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivatePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> {

            finish();
        });



    }
}