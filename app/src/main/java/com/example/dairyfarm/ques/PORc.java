package com.example.dairyfarm.ques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dairyfarm.Consumer_homepage;
import com.example.dairyfarm.databinding.ActivityPorcBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class PORc extends AppCompatActivity {
    RadioButton radiobutton;
    RadioGroup radioGroup;
    Button porcnext;





        @Override
        public void onCreate(Bundle savedInstanceState) {
            ActivityPorcBinding binding;
            super.onCreate(savedInstanceState);
            binding = ActivityPorcBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());


            radioGroup = (RadioGroup) findViewById(androidx.appcompat.R.id.radio);
            binding.radioButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
//                     get selected radio button from radioGroup
                    int selectedId = radioGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radiobutton = (RadioButton) findViewById(selectedId);

                    Toast.makeText(PORc.this,
                            radiobutton.getText(), Toast.LENGTH_SHORT).show();
                    Data data = Data.getInstance();
                    data.setA(1);
//                    data.setA(radiobutton.getText().toString());

                    startActivity(new Intent(PORc.this, Location.class));
                        finish();




                }
            });
            binding.radioButton2.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
//                    get selected radio button from radioGroup
                    int selectedId = radioGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radiobutton = (RadioButton) findViewById(selectedId);

                    Toast.makeText(PORc.this,
                            radiobutton.getText(), Toast.LENGTH_SHORT).show();
                    Data data = Data.getInstance();
                    data.setA(2);
//                    data.setA(radiobutton.getText().toString());
                    startActivity(new Intent(PORc.this, Location.class));
                    finish();

                }
            });
        }
}


