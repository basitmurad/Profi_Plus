package com.basit.profitplus.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.Toast;


import com.basit.profitplus.databinding.ActivityConfirmPakageBinding;
import com.basit.profitplus.models.PackagesDetails;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ConfirmPackageActivity extends AppCompatActivity {


    private ActivityConfirmPakageBinding binding;
    private String amount, bonus, durations;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    private FirebaseUser currentUser;
    PackagesDetails packagesDetails;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmPakageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        userID = currentUser.getUid();


        databaseReference = FirebaseDatabase.getInstance().getReference("ActivatedPackages");
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Activating Your package");


        amount = getIntent().getStringExtra("Amount");
        bonus = getIntent().getStringExtra("bonus");
        durations = getIntent().getStringExtra("duration");

//        Toast.makeText(this, ""+amount + bonus + durations, Toast.LENGTH_SHORT).show();


        binding.bonusAmount.setText(bonus + " Rs");
        binding.packageamm.setText(amount + " Rs");
        binding.packDur.setText(durations + "Days");


//        packagesDetails.setPackageAmount(amount);
//        packagesDetails.setPackageBonus(bonus);
//        packagesDetails.setPackageDurations(durations);


        binding.btnActivates.setOnClickListener(v -> {

            PackagesDetails packagesDetails1 = new PackagesDetails(amount ,bonus , durations);



            databaseReference.child(userID).push().setValue(packagesDetails1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isComplete()) {
                        Toast.makeText(ConfirmPackageActivity.this, "Update", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ConfirmPackageActivity.this, "no updated", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnCanceledListener(new OnCanceledListener() {
                @Override
                public void onCanceled() {


                    Toast.makeText(ConfirmPackageActivity.this, "database error", Toast.LENGTH_SHORT).show();
                }
            });


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                    startActivity(new Intent(ConfirmPackageActivity.this, DashboardActivity.class));
                }
            }, 1000);

        });

    }
}