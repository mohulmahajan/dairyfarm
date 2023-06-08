package com.example.dairyfarm.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.ActivityButterBinding;
import com.example.dairyfarm.ques.Data;

public class butter extends AppCompatActivity {
ActivityButterBinding binding;
    int qty;
    int butterqty=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityButterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.imageView3.setImageResource(R.drawable.butter);

        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty= Integer.parseInt(binding.editquantity.getText().toString());
                if (qty==0){
                    Toast.makeText(butter.this, "Quantity cannot be less than '0'", Toast.LENGTH_SHORT).show();
                }
                else if(qty>0){
                    qty= (Integer.parseInt(binding.editquantity.getText().toString())-1);
                    binding.editquantity.setText(String.valueOf(qty));
                }
            }
        });

        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty= (Integer.parseInt(binding.editquantity.getText().toString())+1);
                binding.editquantity.setText(String.valueOf(qty));
            }
        });


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                butterqty= (Integer.parseInt(binding.editquantity.getText().toString()));
                Data data=Data.getInstance();
                data.setButterqt(butterqty);

            }
        });
    }
}