package com.basit.profitplus.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.basit.profitplus.R;
import com.basit.profitplus.databinding.ActivitySignUpBinding;
import com.basit.profitplus.helper.HideKeyBoard;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private static final int IMAGE_REQUEST = 13;

    private String email , password , cnic, name , city , number ;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait......");
        dialog.setCancelable(false);
        binding.btnBack.setOnClickListener(v -> {
            finish();
        });
        binding.textSignIn.setOnClickListener(v -> {
            finish();
        });
        binding.btnCreatAccount.setOnClickListener(v -> {
            if (binding.etEmail.getText().toString().isEmpty())
                Toast.makeText(this, "Email required", Toast.LENGTH_SHORT).show();
            else if (binding.etPassword.getText().toString().isEmpty())
                Toast.makeText(this, "Password required", Toast.LENGTH_SHORT).show();
            else if (binding.etName.getText().toString().isEmpty())
                Toast.makeText(this, "Name required", Toast.LENGTH_SHORT).show();
            else if (binding.etNumber.getText().toString().isEmpty())
                Toast.makeText(this, "Number required", Toast.LENGTH_SHORT).show();

            else if (binding.etAddress.getText().toString().isEmpty())
                Toast.makeText(this, "Address required", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(this, "Account Created successfully", Toast.LENGTH_SHORT).show();

            HideKeyBoard.hideKeyboard(this);

        });
    }

    private void checkValidation() {

        if (binding.etName.getText().toString().isEmpty())
        {
            binding.etName.setError("Name is empty");
        }

        if (binding.etPassword.getText().toString().isEmpty())
        {
            binding.etPassword.setError("Password is empty");
        }
        else if (binding.etPassword.length()<8)
        {
            binding.etPassword.setError("Less the 8 character");

        }

//        if (binding.etCnic.getText().toString().isEmpty())
//        {
//            binding.etCnic.setError("CNIC is empty");
//        }
//
//        if (binding.etCity.getText().toString().isEmpty())
//        {
//            binding.etCity.setError("City is empty");
//        }

        if (binding.etNumber.getText().toString().isEmpty())
        {
            binding.etNumber.setError("Number is empty");
        }
        if (binding.etEmail.getText().toString().isEmpty())
        {
            binding.etEmail.setError("Email is empty");
        }


        else {
            name = binding.etName.getText().toString();
            email = binding.etEmail.getText().toString();
            password = binding.etPassword.getText().toString();
//            cnic = binding.etCnic.getText().toString();
//            city = binding.etCity.getText().toString();
            number = binding.etNumber.getText().toString();


            Toast.makeText(this, "Account Created successfully", Toast.LENGTH_SHORT).show();
        }
    }


    private void pickImage() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, IMAGE_REQUEST);

    }

//    private void createAccount(String email, String password, String first_name, String sur_name, String phone_number, String referral_id, String address) {
//        dialog.show();
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, task -> {
//                    if (task.isSuccessful()) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "createUserWithEmail:success");
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
////                        binding.textCreate.setVisibility(View.VISIBLE);
////                        binding.progressSignUp.setVisibility(View.GONE);
////         binding.textCreate.setText("Authenticated ! Save the data");
//                        uploadImage(uri, new User(binding.etEmail.getText().toString(), binding.etPassword.getText().toString(), binding.etFirstName.getText().toString(), binding.etSurname.getText().toString(), binding.etPhoneNumber.getText().toString(), userReferralCode, binding.etAddress.getText().toString(), userId, "", "", "", false, false, String.valueOf(System.currentTimeMillis())));
//                        // uploadData(email, password, first_name, sur_name, phone_number, referral_id, address, userId);
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        dialog.dismiss();
//                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                        Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//    }


}