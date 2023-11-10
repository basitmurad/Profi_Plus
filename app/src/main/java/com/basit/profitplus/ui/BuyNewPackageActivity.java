package com.basit.profitplus.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityBuyNewPackageBinding;

public class BuyNewPackageActivity extends AppCompatActivity {


    private ActivityBuyNewPackageBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyNewPackageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.appCompatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (binding.editTextAccount.getText().toString().isEmpty())
                {
                    binding.editTextAccount.setError("Please enter the account using which you have payment ");
                }

                if (binding.editTextTranscationdId.getText().toString().isEmpty())
                {
                    binding.editTextTranscationdId.setError("Enter Valid Transcation ID");
                }

                if (binding.paymentScreenShot!=null)
                {
                    Toast.makeText(BuyNewPackageActivity.this, "Please upload the screenshot of payment", Toast.LENGTH_SHORT).show();
                }

                else {


                    Toast.makeText(BuyNewPackageActivity.this, "Please wait for approval of your payment\n" +
                            "payment will be accept in  1 hours", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    private void showDialoge() {



    }
}