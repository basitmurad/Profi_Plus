package com.basit.profitplus.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.helper.Constant;
import com.basit.profitplus.ui.ActivatePackagesActivity;
import com.basit.profitplus.ui.ActiveBalanceActivity;
import com.basit.profitplus.ui.BuyNewPackageActivity;
import com.basit.profitplus.ui.MyInvitesActivity;
import com.basit.profitplus.ui.PaymentSelectionActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class DashboardFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);


        ConstraintLayout layoutActiveBalance = view.findViewById(R.id.layoutActiveBalance);
        LinearLayout activePackageLayout = view.findViewById(R.id.linearLayout3);
        LinearLayout layoutBuyNewPackage = view.findViewById(R.id.layoutBuyNewPackage);
        LinearLayout layoutDeposit = view.findViewById(R.id.linearLayout9);
        ConstraintLayout layoutInvites = view.findViewById(R.id.constraintLayout2);
        ImageView btnWhatsapp = view.findViewById(R.id.imgWhat);




        btnWhatsapp.setOnClickListener(v -> {
openWhatsApp();
        });




        layoutInvites.setOnClickListener(v -> startActivity(new Intent(getActivity().getApplicationContext(), MyInvitesActivity.class)));


//        layoutDeposit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DepositBalanceFragment bottomSheetFragment = new DepositBalanceFragment();
////                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
//                bottomSheetFragment.show(getChildFragmentManager(),bottomSheetFragment.getTag());
//            }
//        });
        layoutDeposit.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(requireContext());
            View bottomsheetView = LayoutInflater.from(requireContext()).
                    inflate(R.layout.bottom_sheet_layout, (CardView) getView().findViewById(R.id.cardBalance));
            dialog.setContentView(bottomsheetView);
            dialog.show();

            AppCompatButton button = bottomsheetView.findViewById(R.id.btnNextBalance);
            EditText editText = bottomsheetView.findViewById(R.id.etBalanceDeposit);

            button.setOnClickListener(v1 -> {
                if (editText.getText().toString().isEmpty() ) {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter your deposit balance", Toast.LENGTH_SHORT).show();
                } else {
                    int balance = Integer.parseInt((editText.getText().toString()));

                    if (balance>500)
                    {
                        Intent intent = new Intent(requireContext(), PaymentSelectionActivity.class);
                        intent.putExtra("balance", balance);
                        dialog.cancel();
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(getActivity().getApplicationContext(), "Minimum deposit amount should be\ngreater than 500 " , Toast.LENGTH_SHORT).show();
                    }

                }
            });


        });

        activePackageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ActivatePackagesActivity.class));

            }
        });

        layoutBuyNewPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BuyNewPackageActivity.class));

            }
        });









        return  view;
    }


    private void openWhatsApp() {


        Uri uri = Uri.parse("smsto:" +Constant.PHONE_NUMBER_ADMIN);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
//
//            String phoneNumber = "1234567890"; // Replace with the phone number you want to send the message to
//
//            // Use Uri.parse to create a Uri from the phone number
//            Uri uri = Uri.parse("smsto:" + phoneNumber);
//
//            // Create an Intent with the ACTION_SENDTO action and the Uri
//            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//
//            // Set the message text (optional)
//            intent.putExtra("sms_body", "Hello, this is a test message!");
//
//            // Check if WhatsApp is installed on the device
//            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
//                // Start the activity
//                startActivity(intent);
//            } else {
//                // WhatsApp is not installed, display a message to the user
//                Toast.makeText(requireContext(), "WhatsApp is not installed on your device", Toast.LENGTH_SHORT).show();
//            }
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + Constant.PHONE_NUMBER_ADMIN + "&text=" + Uri.encode(Constant.DEFAULT_MESSAGE)));
//
//// Verify that WhatsApp is installed on the device
//        PackageManager packageManager = requireContext().getPackageManager();
//        if (intent.resolveActivity(packageManager) != null) {
//            // WhatsApp is installed, start the activity
//            startActivity(intent);
//        } else {
//            // WhatsApp is not installed, display an error message or redirect to the Play Store
//            Toast.makeText(requireContext(), "WhatsApp is not installed.", Toast.LENGTH_SHORT).show();
//        }
    }

}