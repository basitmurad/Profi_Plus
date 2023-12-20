package com.basit.profitplus.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.basit.profitplus.databinding.ActivityActiveBalanceBinding;



import java.util.ArrayList;

public class ActiveBalanceActivity extends AppCompatActivity {


    private ActivityActiveBalanceBinding binding;
    private String account, id , amount;
    private boolean isImageUploaded = false;

    String adminAccount  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActiveBalanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


            ClipboardManager clipboardManager =
                    (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

            // Create a ClipData object to hold the text
            ClipData clipData = ClipData.newPlainText("label", adminAccount);

            // Set the ClipData on the clipboard
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(clipData);
            }
       ;



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

//    private boolean checkValidation() {
//        if (binding.editTextAccount.getText().toString().isEmpty()) {
//            binding.editTextAccount.setError("Please enter the account using which you have payment ");
//            return false;
//        }
//
//        if (binding.editTextTranscationdId.getText().toString().isEmpty()) {
//            binding.editTextTranscationdId.setError("Enter Valid Transcation ID");
//            return false;
//        }
//
//        account = binding.editTextAccount.getText().toString();
//        id = binding.editTextTranscationdId.getText().toString();
//        return true;
//    }

    private void openFileManager() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");


        startActivityForResult(intent, 1);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
//            Uri imageUri = data.getData();
//
//
////
//            Glide.with(this).load(imageUri).into(binding.paymentScreenShot);
//
//            isImageUploaded = true;
////            Toast.makeText(this, "Upload successfully", Toast.LENGTH_SHORT).show();
//
//
//        }
//    }

}
