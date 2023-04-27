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
import com.example.dairyfarm.ques.Data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class Prod_dealsin extends AppCompatActivity {
ActivityProdDealsinBinding binding;
    List<DocumentSnapshot> abcd;
    ProductModel productModel;
    List<DocumentSnapshot> abc;
    String Milk = "", paneer = "", curd = "", cheese = "", buttermilk = "", ghee = "";
    String[] arr = {"Milk", "paneer", "curd", "cheese", "buttermilk", "ghee"};
    String abcde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityProdDealsinBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());




//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        abc=queryDocumentSnapshots.getDocuments();
//                        for (DocumentSnapshot documentSnapshot:abc){
//                            productModel=documentSnapshot.toObject(ProductModel.class);
//                        }
//                       if (productModel.getMilk().toString()=="true"){Milk="MILK";}
//                       if (productModel.getCheese().toString()=="true"){cheese="CHEESE";}
//                       if (productModel.getCurd().toString()=="true"){curd="CURD";}
//                       if (productModel.getButtermilk().toString()=="true"){buttermilk="BUTTERMILK";}
//                       if (productModel.getPaneer().toString()=="true"){paneer="PANEER";}
//                       if (productModel.getGhee().toString()=="true"){ghee="GHEE";}
//                         abcde= (Milk + cheese + curd + buttermilk + paneer + ghee);
//                        binding.abc.setText(abcde.toString());
//                    }
//                })


        binding.gobackprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Prod_dealsin.this,ProfileTest.class));

            }
        });
//        getvalue();


        binding.Milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
//    public void getvalue(){
//        Data data= Data.getInstance();
//        if (data.getMilk()==1){Milk="MILK";}
//        if (data.getCheese()==1){cheese="CHEESE";}
//        if (data.getCurd()==1){curd="CURD";}
//        if (data.getButtermilk()==1){buttermilk="BUTTERMILK";}
//        if (data.getPaneer()==1){paneer="PANEER";}
//        if (data.getGhee()==1){ghee="GHEE";}
//        abcde= (Milk + cheese + curd + buttermilk + paneer + ghee);
//    }


}