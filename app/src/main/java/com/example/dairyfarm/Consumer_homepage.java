package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.dairyfarm.adapter.ProducerAdapter;
import com.example.dairyfarm.databinding.ActivityHomepageBinding;
import com.example.dairyfarm.model.ProductModel;
import com.example.dairyfarm.model.UserModel;
import com.example.dairyfarm.ques.Data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;
import java.util.List;

public class Consumer_homepage extends AppCompatActivity {
    ActivityHomepageBinding binding;
    ProducerAdapter producerAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getProducers();
        producerAdapter =new ProducerAdapter(this);
        binding.producerList.setAdapter(producerAdapter);
        binding.producerList.setLayoutManager(new LinearLayoutManager( this));


//        drawerLayout=findViewById(R.id.drawerlayout);
//        navigationView=findViewById(R.id.navigation);
//        toolbar=findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//
//        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id= item.getItemId();
//                if (id==R.id.signout){
//                    FirebaseAuth.getInstance().signOut();
//
//                    startActivity(new Intent(Consumer_homepage.this,MainActivity.class));
//
//                }
//                else if (id==R.id.updateconsumer){
//                    Log.d("ab","error1");
//                }
//                else if (id==R.id.Terms){
//                    Log.d("ab","error1");
//                }
//                else if (id==R.id.Lang){
//                    Log.d("ab","error1");
//                }
//                else if (id==R.id.Contact){
//                    Log.d("ab","error1");
//                }
//
//
//                return true;
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu,menu);
        return true;
    }
    //  Method to decide the functionality of different options in the menu of the application.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.signout){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(Consumer_homepage.this,MainActivity.class));
            finish();
            return true;
        }
        if(id==R.id.Terms){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wto.org/english/thewto_e/procurement_e/terms_conditions_e.pdf"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.Contact){
            startActivity(new Intent(Consumer_homepage.this,Contact_Us.class));
            return true;
        }
        if(id==R.id.Lang){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=dairy%20farm&c=apps"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.updateconsumer){
            startActivity(new Intent(Consumer_homepage.this,ProducerHomepage.class));
            return true;
        }
        return true;
    }



    private void getProducers() {


        FirebaseFirestore.getInstance()
                .collection("user")
                .whereEqualTo("pc",2)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> documentSnapshotList=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot ds:documentSnapshotList){
                            UserModel userModel=ds.toObject(UserModel.class);
                            producerAdapter.addProducer(userModel);

                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


    }
}