package com.example.dairyfarm.ques;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dairyfarm.Consumer_homepage;
import com.example.dairyfarm.MainActivity;
import com.example.dairyfarm.R;
import com.example.dairyfarm.SignupActivity;
import com.example.dairyfarm.databinding.ActivityLocationBinding;
import com.example.dairyfarm.model.UserModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

public class Location extends AppCompatActivity {
    ListView CityData;
    ArrayAdapter<String> adapter;
    String[] arrayPeliculas = {"Delhi", "Sonepat", "Panipat", "Karnal", "Ambala", "Panchkula"};
    String itemselected;

    String Delhi="",Sonepat="",Panipat="",Karnal="",Ambala="",Panchkula="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ActivityLocationBinding binding;
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.locationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datasignup data1=Datasignup.getInstance();
                String name = data1.getName();
                String email = data1.getEmail();
                String password = data1.getPassword();
                createAccount(name, email, password);
//                addDetail();


            }
        });

        CityData = findViewById(R.id.CityData);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arrayPeliculas);
        CityData.setAdapter(adapter);


    }


    public void getValue(){
        itemselected = "";
        for (int i = 0; i < CityData.getCount(); i++) {
            if (CityData.isItemChecked(i)) {
                itemselected += CityData.getItemAtPosition(i) + ",";
            }}
        if (CityData.isItemChecked(0)){
            Delhi="true";
        }
        if (CityData.isItemChecked(1)){
            Sonepat="true";
        }
        if (CityData.isItemChecked(2)){
            Panipat="true";
        }
        if (CityData.isItemChecked(3)){
            Karnal="true";
        }
        if (CityData.isItemChecked(4)){
            Ambala="true";
        }
        if (CityData.isItemChecked(5)){
            Panchkula="true";
        }



        Data data = Data.getInstance();
        data.setB(itemselected);
        data.setDelhi(Delhi);
        data.setSonepat(Sonepat);
        data.setPanipat(Panipat);
        data.setKarnal(Karnal);
        data.setAmbala(Ambala);
        data.setPanchkula(Panchkula);
        Log.d("loc",itemselected);

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    void addDetail () {
        getValue();
        Datasignup data1= Datasignup.getInstance();
        Data data = Data.getInstance();
        UserModel usermodel = new UserModel(data1.getName(),data1.getEmail(),data1.getPhn(),data.getA(),itemselected,data.getDelhi(),data.getSonepat(), data.getPanipat(), data.getKarnal(),data.getAmbala(),data.getPanchkula());
        FirebaseFirestore.getInstance()
                .collection("user")
                .document(data1.getEmail())
                .set(usermodel);

        startActivity(new Intent(Location.this,MainActivity.class));
        finish();
    }

    public void createAccount(String name, String email, String password) {

        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Creating");
        progressDialog.setMessage("Account");
        progressDialog.show();
        fAuth.createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name).build();
                        FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileChangeRequest);
                        progressDialog.cancel();
                        Toast.makeText(Location.this, "Account Created", Toast.LENGTH_SHORT).show();
                        FirebaseAuth.getInstance().signOut();
                        addDetail();


//                        binding.name.setText("");
//                        binding.email.setText("");
//                        binding.password.setText("");


                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Location.this, "", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    }
                });



    }


}