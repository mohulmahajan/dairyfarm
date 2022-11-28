package com.example.dairyfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dairyfarm.databinding.ActivityProfilepageBinding;
import com.example.dairyfarm.model.UserModel;

public class ProfilePage extends AppCompatActivity {
    ActivityProfilepageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityProfilepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();

        UserModel userModel=(UserModel) intent.getSerializableExtra("model");

        binding.textView5.setText(userModel.getName());
        binding.textView11.setText(userModel.getPhn());
        binding.textView14.setText(userModel.getEmail());
        binding.textView7.setText(userModel.getLoc());



    }





}