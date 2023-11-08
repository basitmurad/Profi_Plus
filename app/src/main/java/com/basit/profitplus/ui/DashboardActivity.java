package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityDashboardBinding;
import com.basit.profitplus.fragments.ActiveBalanceFragment;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnActiveBalance.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {


                startActivity(new Intent(DashboardActivity.this, ActiveBalanceActivity.class));

            }
        });

        binding.btnActivatePackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ActivatePakagesActivity.class));
            }
        });


        binding.btnActivePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ActivePackagesActivity.class));
            }
        });
    }





}