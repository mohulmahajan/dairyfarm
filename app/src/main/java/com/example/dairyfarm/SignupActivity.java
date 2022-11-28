package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.databinding.ActivitySignUpBinding;
import com.example.dairyfarm.ques.Datasignup;
import com.example.dairyfarm.ques.Location;
import com.example.dairyfarm.ques.PORc;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
                finish();


            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, PORc.class));
                finish();
                Datasignup data1= Datasignup.getInstance();
                data1.setName(binding.name.getText().toString());
                data1.setEmail(binding.email.getText().toString());
                data1.setPassword(binding.password.getText().toString());
                data1.setPhn(binding.phoneno.getText().toString());

            }
        });
    }


}