package com.basit.profitplus.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.basit.profitplus.adapters.ActivatedPackageAdapter;
import com.basit.profitplus.adapters.FragmentAdapter;
import com.basit.profitplus.adapters.PackageDetailsAdapter;
import com.basit.profitplus.databinding.ActivityActivatePakagesBinding;
import com.basit.profitplus.models.PackagesDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivatePackagesActivity extends AppCompatActivity {

    private ActivityActivatePakagesBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivatePakagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.btnBack.setOnClickListener(v -> {

            finish();
        });


        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(adapter);


    }
}