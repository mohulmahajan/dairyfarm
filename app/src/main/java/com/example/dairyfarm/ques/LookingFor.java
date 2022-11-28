package com.example.dairyfarm.ques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dairyfarm.Consumer_homepage;
import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.ActivityLookingForBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class LookingFor extends AppCompatActivity{
    RadioButton radiobutton;
    RadioGroup radioGroup;
    Button button ;
    String text1;
    Map<String, Object> LookingForo= new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityLookingForBinding binding;
        super.onCreate(savedInstanceState);
        binding = ActivityLookingForBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radioGroup = (RadioGroup) findViewById(androidx.appcompat.R.id.radio);
        button = (Button) findViewById(R.id.Lookingbtn);
        binding.Lookingbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
//                int selectedId = radioGroup.getCheckedRadioButtonId();
//
//                // find the radiobutton by returned id
//                radiobutton = (RadioButton) findViewById(selectedId);
//
//                Toast.makeText(LookingFor.this,
//                        radiobutton.getText(), Toast.LENGTH_SHORT).show();
//
//                text1 = radiobutton.getText().toString();
//                Data data=Data.getInstance();
//                LookingForo.put("Lookingfor",data.getPc());
//                FirebaseFirestore db=FirebaseFirestore.getInstance();
//                db.collection("ques")
//                        .document()
//                        .set(LookingForo);
//                addDetail();

                startActivity(new Intent(LookingFor.this, Consumer_homepage.class));
                finish();
            }
        });
    }



}

