package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
;

import com.basit.profitplus.databinding.ActivityPaymentSelectionBinding;


public class PaymentSelectionActivity extends AppCompatActivity {


    private ActivityPaymentSelectionBinding binding;
    String amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        amount = String.valueOf(getIntent().getIntExtra("balance", 0));

        Toast.makeText(this, ""+amount, Toast.LENGTH_SHORT).show();

        binding.btnEasyPaisa.setOnClickListener(v -> {
            Intent intent = new Intent(this,DepositeActivity.class);
            intent.putExtra("account","usd");
//            intent.putExtra("balance",balance);
            startActivity(intent);
        });

        binding.btnJazzCash.setOnClickListener(v -> {
            Intent intent = new Intent(this,DepositeActivity.class);
            intent.putExtra("account","usd");
//            intent.putExtra("balance",balance);
            startActivity(intent);
        });

        binding.btnSadaPay.setOnClickListener(v -> {
            Intent intent = new Intent(this,DepositeActivity.class);
            intent.putExtra("account","usd");
//            intent.putExtra("balance",balance);
            startActivity(intent);
        });


//        binding.btnBack.setOnClickListener(v -> finish());
    }


}