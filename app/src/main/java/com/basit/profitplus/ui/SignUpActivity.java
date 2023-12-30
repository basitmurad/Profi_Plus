package com.basit.profitplus.ui;

import static com.basit.profitplus.helper.HideKeyBoard.hideKeyboard;

import androidx.annotation.NonNull;
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
import com.basit.profitplus.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private static final int IMAGE_REQUEST = 13;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private String email, password, userId, name, address, number;
    ProgressDialog dialog;
    private DatabaseReference usersRef;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();


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
            if (binding.etName.getText().toString().isEmpty())
                Toast.makeText(this, "Name required", Toast.LENGTH_SHORT).show();

            else if (binding.etEmail.getText().toString().isEmpty())
                Toast.makeText(this, "Email required", Toast.LENGTH_SHORT).show();

            else if (binding.etPassword.getText().toString().isEmpty())
                binding.etPassword.setError("Password required");

            else if (binding.etPassword.getText().toString().trim().length() < 8)
                binding.etPassword.setError("Password must be at least 8 characters long");

            else if (binding.etNumber.getText().toString().isEmpty())
                Toast.makeText(this, "Number required", Toast.LENGTH_SHORT).show();

            else if (binding.etNumber.getText().toString().trim().length() < 11)
                Toast.makeText(this, "Number must be at least 11 characters long", Toast.LENGTH_SHORT).show();

            else if (binding.etAddress.getText().toString().isEmpty())
                Toast.makeText(this, "Address required", Toast.LENGTH_SHORT).show();

            else {

                dialog.setTitle("PLease wait..");
                dialog.setMessage("Creating account");
                dialog.setCancelable(false);
                dialog.show();
                hideKeyboard(this);

                name = binding.etName.getText().toString();
                password = binding.etPassword.getText().toString();
                email = binding.etEmail.getText().toString();
                number = binding.etNumber.getText().toString();
                address = binding.etAddress.getText().toString();


                createAccountWithEmailAndPassword(email, password);


            }
        });
    }

    private void createAccountWithEmailAndPassword(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            hideKeyboard(SignUpActivity.this);
                            userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            SendDataToFireBase();
                        } else {
                            dialog.dismiss();
                            Log.e("tag", "Account creation failed: " + task.getException());
                            // Toast.makeText(RegistrationActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void SendDataToFireBase() {
        Users users = new Users(name, email, number, password, userId);
        databaseReference.child(userId).setValue(users)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        finish();
                        dialog.dismiss();
                        Intent intent = new Intent(SignUpActivity.this, DashboardActivity.class);


                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Try Again...\n something went wrong", Toast.LENGTH_SHORT).show();

                        Toast.makeText(SignUpActivity.this, "" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }


}


