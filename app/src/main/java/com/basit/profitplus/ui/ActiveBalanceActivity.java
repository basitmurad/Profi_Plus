package com.basit.profitplus.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityActivePakagesBinding;
import com.bumptech.glide.Glide;

public class ActiveBalanceActivity extends AppCompatActivity {


    private ActivityActivePakagesBinding binding;
    private String account, id , amount;
    private boolean isImageUploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.appCompatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (binding.editTextAccount.getText().toString().isEmpty()) {
                    Toast.makeText(ActiveBalanceActivity.this, "Your account", Toast.LENGTH_SHORT).show();
                }
                if (binding.editTextTranscationdId.getText().toString().isEmpty()) {
                    Toast.makeText(ActiveBalanceActivity.this, "Enter the transaction Id", Toast.LENGTH_SHORT).show();
                }
                if (binding.editTextAmount.getText().toString().isEmpty()) {
                    Toast.makeText(ActiveBalanceActivity.this, "Enter the amount", Toast.LENGTH_SHORT).show();
                }
                else {

                    account = binding.editTextAccount.getText().toString();
                    id = binding.editTextTranscationdId.getText().toString();
                    amount = binding.editTextAmount.getText().toString();

                    showDialog(ActiveBalanceActivity.this);
                }
            }
        });



    }
    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Your Request is in ")
                .setMessage("Hello! This is a dialog box.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle positive button click
                        dialog.dismiss();

                        finish();
                    }
                });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean checkValidation() {
        if (binding.editTextAccount.getText().toString().isEmpty()) {
            binding.editTextAccount.setError("Please enter the account using which you have payment ");
            return false;
        }

        if (binding.editTextTranscationdId.getText().toString().isEmpty()) {
            binding.editTextTranscationdId.setError("Enter Valid Transcation ID");
            return false;
        }

        account = binding.editTextAccount.getText().toString();
        id = binding.editTextTranscationdId.getText().toString();
        return true;
    }

    private void openFileManager() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");


        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();


//
            Glide.with(this).load(imageUri).into(binding.paymentScreenShot);

            isImageUploaded = true;
//            Toast.makeText(this, "Upload successfully", Toast.LENGTH_SHORT).show();


        }
    }

}
