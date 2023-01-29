package com.example.dairyfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dairyfarm.databinding.ActivityAddproductBinding;
import com.example.dairyfarm.model.ProductModel;
import com.example.dairyfarm.ques.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Addproduct extends AppCompatActivity {
    ActivityAddproductBinding binding;
    ListView Productlist;
    ArrayAdapter<String> adapter;
    String[] arr = {"Milk", "paneer", "curd", "cheese", "buttermilk", "ghee"};
    String items;

    String Milk = "", paneer = "", curd = "", cheese = "", buttermilk = "", ghee = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddproductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Productlist = findViewById(R.id.ProdList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
        Productlist.setAdapter(adapter);

        binding.addproductbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValue();
                Add();
                startActivity(new Intent(Addproduct.this,ProducerHomepage.class));

            }
        });

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.producer_option,menu);
//        return true;
//    }
//    //  Method to decide the functionality of different options in the menu of the application.
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id=item.getItemId();
//        if(id==R.id.signoutprod){
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(Addproduct.this,MainActivity.class));
//            finish();
//            return true;
//        }
//        if(id==R.id.Termsprod){
//            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wto.org/english/thewto_e/procurement_e/terms_conditions_e.pdf"));
//            startActivity(intent);
//            return true;
//        }
//        if(id==R.id.Contactprod){
//            startActivity(new Intent(Addproduct.this,Contact_Us.class));
//            return true;
//        }
//        if(id==R.id.Langprod){
//            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=dairy%20farm&c=apps"));
//            startActivity(intent);
//
//            return true;
//        }
//        if(id==R.id.updateproduct){
//            startActivity(new Intent(Addproduct.this,Addproduct.class));
//            return true;
//        }
//        return true;
//    }

    public void getValue(){

        items="";
        for (int i = 0; i < Productlist.getCount(); i++) {
        if (Productlist.isItemChecked(i)) {
            items+= Productlist.getItemAtPosition(i) + ",";
        }}
        if (Productlist.isItemChecked(0)){
            Milk="true";
        }if (Productlist.isItemChecked(1)){
            paneer="true";}
        if (Productlist.isItemChecked(2)){
            curd="true";}
        if (Productlist.isItemChecked(3)){
            cheese="true";}
        if (Productlist.isItemChecked(4)){
            buttermilk="true";}
        if (Productlist.isItemChecked(5)){
            ghee="true";}

        Data data=Data.getInstance();
        data.setMilk(Milk);
        data.setPaneer(paneer);
        data.setCurd(curd);
        data.setCheese(cheese);
        data.setButtermilk(buttermilk);
        data.setGhee(ghee);
        Log.d("prod",items);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if(id==R.id.item1){
//            items="";
//            for (int i = 0; i < Productlist.getCount(); i++) {
//                if (Productlist.isItemChecked(i)) {
//                    items+= Productlist.getItemAtPosition(i) + ",";
//                }}
//            if (Productlist.isItemChecked(1)){
//                Milk="true";
//            }if (Productlist.isItemChecked(2)){
//                paneer="true";}
//            if (Productlist.isItemChecked(3)){
//                curd="true";}
//            if (Productlist.isItemChecked(4)){
//                cheese="true";}
//            if (Productlist.isItemChecked(5)){
//                buttermilk="true";}
//            if (Productlist.isItemChecked(6)){
//                ghee="true";}
//
//            Data data=Data.getInstance();
//            data.setMilk(Milk);
//            data.setPaneer(paneer);
//            data.setCurd(curd);
//            data.setCheese(cheese);
//            data.setButtermilk(buttermilk);
//            data.setGhee(ghee);
//            Log.d("prod",items);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    public void Add(){
        Data data=Data.getInstance();
        ProductModel productModel=new ProductModel(data.getMilk(),data.getPaneer(),data.getCurd(),data.getCheese(),data.getButtermilk(),data.getGhee());
        FirebaseFirestore.getInstance()
                .collection("product")
                .document()
                .set(productModel);
    }



}