package com.example.dairyfarm;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.databinding.ActivityProdDealsinBinding;
import com.example.dairyfarm.model.ProductModel;
import com.example.dairyfarm.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class Prod_dealsin extends AppCompatActivity {
ActivityProdDealsinBinding binding;
    List<DocumentSnapshot> abcd;
    ProductModel productModel;
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
        getvalue();
    }
    public void getvalue(){






    }


}