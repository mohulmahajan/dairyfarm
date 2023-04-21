package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.databinding.ActivityMainBinding;
import com.example.dairyfarm.model.UserModel;
import com.example.dairyfarm.ques.Data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<DocumentSnapshot> abc;
    UserModel userModel;
    String email;
    int pcvalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
                finish();
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=binding.email.getText().toString();
                String password=binding.password.getText().toString();
                Data data=Data.getInstance();
                data.setEmailOnLogin(email);

                login(email,password);


                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    FirebaseFirestore.getInstance()
                            .collection("user")
                            .whereEqualTo("email",email)
                            .get()


                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    abc=queryDocumentSnapshots.getDocuments();
                                    for (DocumentSnapshot documentSnapshot:abc){
                                        userModel=documentSnapshot.toObject(UserModel.class);
                                    }
                                    pcvalue=userModel.getPc();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            });

                }
                else{
//                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }

    public void login(String email, String password){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("In process");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email.trim(),password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.cancel();
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        onStart();

//                        Query user= db.collection("user").whereEqualTo("email", data.getEmail()).whereEqualTo("pc", "Consumer");
                    }
                })
                
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                         progressDialog.cancel();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
        public void onStart() {
            super.onStart();
            //for producer
            if (pcvalue == 2) {
                startActivity(new Intent(MainActivity.this, ProducerHomepage.class));
            }
            //for consumer
            else if (pcvalue == 1) {
                startActivity(new Intent(MainActivity.this, Consumer_homepage.class));
            }

        }

}