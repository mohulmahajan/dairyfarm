package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.databinding.ActivityProfileTestBinding;
import com.example.dairyfarm.model.ProductModel;
import com.example.dairyfarm.model.UserModel;
import com.example.dairyfarm.ques.Data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProfileTest extends AppCompatActivity {
ActivityProfileTestBinding binding;
String loc1;
    List<DocumentSnapshot> abc;
    UserModel userModel;
    String Sonepat;
    ProductModel productModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityProfileTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        binding.DealsInProfile.setOnClickListener(new View.OnClickListener() {
            UserModel userModel=(UserModel) intent.getSerializableExtra("model");
            @Override
            public void onClick(View view) {

            FirebaseFirestore.getInstance()
                    .collection("product")
                    .whereEqualTo("email",userModel.getEmail() )
                    .get()


                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            abc=queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot documentSnapshot:abc){
                                productModel=documentSnapshot.toObject(ProductModel.class);
                            }
                            startActivity(new Intent(ProfileTest.this,Prod_dealsin.class));
                            Log.d("abc", String.valueOf(productModel.getMilk()));
                            Data data = Data.getInstance();
                            data.setMilk(productModel.getMilk());
                            data.setCheese(productModel.getCheese());
                            data.setCurd(productModel.getCurd());
                            data.setButtermilk(productModel.getButtermilk());
                            data.setGhee(productModel.getGhee());
                            data.setPaneer(productModel.getPaneer());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(ProfileTest.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });
        UserModel userModel=(UserModel) intent.getSerializableExtra("model");
        binding.userName.setText(userModel.getName());
        binding.Profilename.setText(userModel.getName());
        binding.profilephn.setText(userModel.getPhn());
        binding.profileemail.setText(userModel.getEmail());


        binding.ProfileLoc.setText(userModel.getLoc());
//        Log.d("loc",loc1);

        StorageReference storageReference= FirebaseStorage.getInstance().getReference("images/" + userModel.getEmail().toString());
        try {
            File localFile= File.createTempFile("tempFile",".jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            binding.Profiledp.setImageBitmap(bitmap);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(ProfileTest.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

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
            startActivity(new Intent(ProfileTest.this,MainActivity.class));
            finish();
            return true;
        }
        if(id==R.id.Terms){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wto.org/english/thewto_e/procurement_e/terms_conditions_e.pdf"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.Contact){
            startActivity(new Intent(ProfileTest.this,Contact_Us.class));
            return true;
        }
        if(id==R.id.Lang){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=dairy%20farm&c=apps"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.updateconsumer){
            startActivity(new Intent(ProfileTest.this,ProducerHomepage.class));
            return true;
        }
        return true;
    }

}