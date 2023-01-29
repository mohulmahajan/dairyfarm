package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dairyfarm.databinding.ActivityProducerhomepageBinding;
import com.example.dairyfarm.model.ProfileModel;
import com.example.dairyfarm.model.UserModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProducerHomepage extends AppCompatActivity {
    UserModel user;
    List<DocumentSnapshot> abcd;
    ActivityProducerhomepageBinding binding;
    String profilephn,profileemail,profilename;
    ProfileModel user1;
    Map<String, Object> user2;
    private ImageView dp;
    private Uri imageUri;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference,storage;



    public ProducerHomepage(){

        getDataProfile();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProducerhomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dp=  binding.img;
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseDp();
            }
        });

        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpdateProfile();


            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){

            imageUri = data.getData();
            dp.setImageURI(imageUri);
            firebaseStorage= FirebaseStorage.getInstance();
            storageReference=firebaseStorage.getReference();
            uploadPicture();
        }
    }
    private void uploadPicture() {
        final ProgressDialog pd= new ProgressDialog(this);
        pd.setTitle("Uploading Image");
        pd.show();


        final String randomKey= UUID.randomUUID().toString();
        StorageReference abcREf= storageReference.child("images/" + FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
        abcREf.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(androidx.appcompat.R.id.content),"Profile Picture updated Soccessfully",Snackbar.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ProducerHomepage.this, "Failed to Upload", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progressPercent=(100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                        pd.setMessage("progress: " + (int) progressPercent + "%" );
                    }
                });

    }

    private void chooseDp() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);



    }
    public void UpdateProfile(){
        String name=  binding.profilename2.getText().toString();
        String phn= binding.profilephn.getText().toString();
        DocumentReference documentReference=FirebaseFirestore.getInstance().collection("user")
                .document(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());

//        Map<String, Object> map = new HashMap<>();
//        map.put("name","vaibhav");
//        documentReference.update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(ProducerHomepage.this,"success",Toast.LENGTH_LONG).show();
//                binding.profilename.setText(binding.profilename.getText());
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(ProducerHomepage.this,"failure",Toast.LENGTH_LONG).show();
//            }
//        });
        documentReference.update("name",name,"phn",phn).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ProducerHomepage.this,"success",Toast.LENGTH_LONG).show();
                binding.profilename.setText(binding.profilename2.getText());
                binding.profilename2.setText(binding.profilename2.getText());
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.producer_option,menu);
        return true;
    }
    //  Method to decide the functionality of different options in the menu of the application.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.signoutprod){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(ProducerHomepage.this,MainActivity.class));
            finish();
            return true;
        }
        if(id==R.id.Termsprod){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wto.org/english/thewto_e/procurement_e/terms_conditions_e.pdf"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.Contactprod){
            startActivity(new Intent(ProducerHomepage.this,Contact_Us.class));
            return true;
        }
        if(id==R.id.Langprod){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=dairy%20farm&c=apps"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.updateproduct){
            startActivity(new Intent(ProducerHomepage.this,Addproduct.class));
            return true;
        }
        return true;
    }

    public void getDataProfile(){
        String email=FirebaseAuth.getInstance().getCurrentUser().getEmail();

        FirebaseFirestore.getInstance()
                .collection("user")
                .whereEqualTo("email",email)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        abcd=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot documentSnapshot:abcd){
                            user=documentSnapshot.toObject(UserModel.class);
                        }
                        profileemail=user.getEmail();
                        profilename=user.getName();
                        profilephn=user.getPhn();
                        binding.profilename.setText(profilename);
                        binding.profilename2.setText(profilename);
                        binding.profileemail.setText(profileemail);
                        binding.profilephn.setText(profilephn);



                        storage=FirebaseStorage.getInstance().getReference("images/" + FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
                        try {
                            File localFile= File.createTempFile("tempFile",".jpg");
                            storage.getFile(localFile)
                                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                        @Override
                                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                            dp.setImageBitmap(bitmap);
                                        }
                                    });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProducerHomepage.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}