package com.example.dairyfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dairyfarm.databinding.ActivityProdDealsinBinding;

public class Prod_dealsin extends AppCompatActivity {
ActivityProdDealsinBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityProdDealsinBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.gobackprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Prod_dealsin.this,ProfileTest.class));

            }
        });

    }


}