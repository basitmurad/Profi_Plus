package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityMyInvitesBinding;

public class MyInvitesActivity extends AppCompatActivity {

    private ActivityMyInvitesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyInvitesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}