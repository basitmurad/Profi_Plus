package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityConfirmPakageBinding;

public class ConfirmPackageActivity extends AppCompatActivity {



    private ActivityConfirmPakageBinding binding;
    private String amount, bonus, durations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmPakageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        amount = getIntent().getStringExtra("Amount");
        bonus = getIntent().getStringExtra("bonus");
        durations = getIntent().getStringExtra("duration");

        Toast.makeText(this, ""+amount + bonus + durations, Toast.LENGTH_SHORT).show();



        binding.bonusAmount.setText(bonus + " Rs");
        binding.packageamm.setText(amount+" Rs");
        binding.packDur.setText(durations );


    }
}