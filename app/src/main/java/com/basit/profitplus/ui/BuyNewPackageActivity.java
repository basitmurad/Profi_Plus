package com.basit.profitplus.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.basit.profitplus.adapters.PackageDetailsAdapter;
import com.basit.profitplus.databinding.ActivityBuyNewPackageBinding;
import com.basit.profitplus.interfaces.OnItemClickListner;
import com.basit.profitplus.models.PackagesDetails;

import java.util.ArrayList;

public class BuyNewPackageActivity extends AppCompatActivity implements OnItemClickListner {
    private ArrayList<PackagesDetails> packagesDetailsArrayList ;

    private PackageDetailsAdapter packageDetailsAdapter;

    private ActivityBuyNewPackageBinding binding ;

    private  String amount;
    int amount1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyNewPackageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        amount = getIntent().getStringExtra("amount");



        amount1 = Integer.parseInt(amount);

        binding.textAmount.setText(String.valueOf(amount1));



        packagesDetailsArrayList = new ArrayList<>();

        packagesDetailsArrayList.add(new PackagesDetails("2000" ,"15" , "600"));
        packagesDetailsArrayList.add(new PackagesDetails("4000" ,"15" , "1200"));
        packagesDetailsArrayList.add(new PackagesDetails("6000" ,"15" , "2400"));
        packagesDetailsArrayList.add(new PackagesDetails("10000" ,"15" , "4800"));
        packagesDetailsArrayList.add(new PackagesDetails("15000" ,"15" , "8600"));
        packagesDetailsArrayList.add(new PackagesDetails("25000" ,"15" , "12600"));
        packagesDetailsArrayList.add(new PackagesDetails("35000" ,"15" , "15600"));
        packagesDetailsArrayList.add(new PackagesDetails("40000" ,"15" , "20000"));
        packagesDetailsArrayList.add(new PackagesDetails("50000" ,"15" , "25000"));



        packageDetailsAdapter = new PackageDetailsAdapter(packagesDetailsArrayList , this , this::OnItemClickListner);

        binding.recycler.setAdapter(packageDetailsAdapter);

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));










    }

    private void showDialoge() {



    }




    @Override
    public void OnItemClickListner(PackagesDetails packagesDetails) {
        // Use the 'packagesDetails' parameter instead of creating a new object
        String amount = packagesDetails.getPackageAmount();

        Toast.makeText(this, "Your balance is" + amount1, Toast.LENGTH_SHORT).show();

        if (Integer.parseInt(amount)<amount1)
        {

            Intent intent = new Intent(BuyNewPackageActivity.this, ConfirmPackageActivity.class);
//
            intent.putExtra("Amount" , packagesDetails.getPackageAmount());
            intent.putExtra("bonus" , packagesDetails.getPackageBonus());
            intent.putExtra("duration" , packagesDetails.getPackageDurations());

            startActivity(intent);
            Toast.makeText(this, " Amount is" +amount, Toast.LENGTH_SHORT).show();
        }

        else {


            alertDialog();
            Toast.makeText(this, "Amount is " +amount1, Toast.LENGTH_SHORT).show();

        }
//        if (amount != null) {
//
//            // Now you can proceed with your logic using the 'amount'
//            // For example, you can check if 'amount' is less than 'amount1' and show the dialog
//            if (Integer.parseInt(amount) < amount1) {
//                showAlertDialog(packagesDetails);
//            } else {
//                Toast.makeText(this, "Package amount is not less than the given amount.", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            // Handle the case where 'amount' is null
//            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
//        }
    }


    private void showAlertDialog(PackagesDetails packageDetails) {
        // Implement your dialog logic here
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Package Confirmation")
                .setMessage("Do you want to proceed with this package?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Handle positive button click
                    // You can implement the logic to proceed with the selected package
                    // For example, start a new activity, make an API call, etc.
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // Handle negative button click or simply dismiss the dialog
                    dialog.dismiss();
                })
                .show();
    }
    private void alertDialog() {
        // Implement your dialog logic here
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Low on Balance")
                .setMessage("Your balance is low please deposit")
                .setPositiveButton("Deposit", (dialog, which) -> {

                    startActivity(new Intent(BuyNewPackageActivity.this, DashboardActivity.class));
                finish();
                    // Handle positive button click
                    // You can implement the logic to proceed with the selected package
                    // For example, start a new activity, make an API call, etc.
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // Handle negative button click or simply dismiss the dialog
                    dialog.dismiss();
                })
                .show();
    }


}