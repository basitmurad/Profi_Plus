package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.basit.profitplus.R;
import com.basit.profitplus.adapters.PackageDetailsAdapter;
import com.basit.profitplus.databinding.ActivityActivatePakagesBinding;
import com.basit.profitplus.databinding.ActivityActiveBalanceBinding;
import com.basit.profitplus.models.PackagesDetails;

import java.util.ArrayList;

public class ActivatePakagesActivity extends AppCompatActivity {

    private ActivityActivatePakagesBinding binding;
    private ArrayList<PackagesDetails> packagesDetailsArrayList ;

    private PackageDetailsAdapter packageDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivatePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        packagesDetailsArrayList = new ArrayList<>();

        packagesDetailsArrayList.add(new PackagesDetails("2 Thousand" ,"15 Days" , "600"));
        packagesDetailsArrayList.add(new PackagesDetails("4 Thousand" ,"15 Days" , "1200"));
        packagesDetailsArrayList.add(new PackagesDetails("6 Thousand" ,"15 Days" , "2400"));
        packagesDetailsArrayList.add(new PackagesDetails("10 Thousand" ,"15 Days" , "4800"));
        packagesDetailsArrayList.add(new PackagesDetails("15 Thousand" ,"15 Days" , "8600"));
        packagesDetailsArrayList.add(new PackagesDetails("25 Thousand" ,"15 Days" , "12600"));
        packagesDetailsArrayList.add(new PackagesDetails("35 Thousand" ,"15 Days" , "15600"));
        packagesDetailsArrayList.add(new PackagesDetails("40 Thousand" ,"15 Days" , "20000"));
        packagesDetailsArrayList.add(new PackagesDetails("50 Thousand" ,"15 Days" , "25000"));



        packageDetailsAdapter = new PackageDetailsAdapter(packagesDetailsArrayList , this);

        binding.recycler.setAdapter(packageDetailsAdapter);

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));




    }
}