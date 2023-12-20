package com.basit.profitplus.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivityDashboardBinding;
import com.basit.profitplus.fragments.DashboardFragment;
import com.basit.profitplus.fragments.LuckDrawsFragment;
import com.basit.profitplus.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.linearLayout9.setOnClickListener(v -> {
//            BottomSheetDialog dialog = new BottomSheetDialog(DashboardActivity.this);
////            View bottomsheetView = LayoutInflater.from(this).
////                    inflate(R.layout.bottom_sheet_layout, (CardView) getView().findViewById(R.id.cardBalance));
//
//            View bottomsheetView = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, findViewById(R.id.cardBalance));
//            dialog.setContentView(bottomsheetView);
//            dialog.show();
//
//            AppCompatButton button = bottomsheetView.findViewById(R.id.btnNextBalance);
//            EditText editText = bottomsheetView.findViewById(R.id.etBalanceDeposit);
//
//            button.setOnClickListener(v1 -> {
//                if (editText.getText().toString().isEmpty()) {
//                    Toast.makeText(this.getApplicationContext(), "Enter your deposit balance", Toast.LENGTH_SHORT).show();
//                } else {
//                    int balance = Integer.parseInt((editText.getText().toString()));
//
//                    if (balance > 500) {
//                        Intent intent = new Intent(this, PaymentSelectionActivity.class);
//                        intent.putExtra("balance", balance);
//                        dialog.cancel();
//                        startActivity(intent);
//
//                    } else {
//                        Toast.makeText(this.getApplicationContext(), "Minimum deposit amount should be\ngreater than 500 ", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            });
//
//
//        });


        binding.layoutBuyNewPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, BuyNewPackageActivity.class));

            }
        });


        binding.linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ActivatePackagesActivity.class));

            }
        });
//        binding.btnWithdraw.setOnClickListener(v -> {
//
//
//        startActivity(new Intent(DashboardActivity.this, WithdrawActivity.class));
//
//        });



        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;


                if (item.getItemId() == R.id.navigation_luckydraw) {
                    LuckDrawsFragment bottomSheetFragment = new LuckDrawsFragment();
                    bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                    return true;
                }

                if (item.getItemId() == R.id.navigation_Profile) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    profileFragment.show(getSupportFragmentManager(), profileFragment.getTag());
                    return true;
                }

//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, selectedFragment)
//                        .commit();

                return true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();


        // Set the default fragment to be displayed when the activity is created
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, new DashboardFragment())
//                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
    }

    //
//        binding.btnActiveBalance.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//
//
//                startActivity(new Intent(DashboardActivity.this, ActiveBalanceActivity.class));
//
//            }
//        });
//
//        binding.btnBuyNewPackages.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DashboardActivity.this, ActivatePakagesActivity.class));
//            }
//        });
//
//
//        binding.btnActivePackage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DashboardActivity.this, ActivePackagesActivity.class));
//            }
//        });
}





