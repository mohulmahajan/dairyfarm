package com.example.dairyfarm.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.ActivityButtermilkBinding;
import com.example.dairyfarm.databinding.ActivityMilkBinding;
import com.example.dairyfarm.ques.Data;

public class Buttermilk extends AppCompatActivity {
ActivityButtermilkBinding binding;
    int qty;
    int buttermilkqty=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityButtermilkBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.imageView3.setImageResource(R.drawable.buttermilk);

        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty= Integer.parseInt(binding.editquantity.getText().toString());
                if (qty==0){
                    Toast.makeText(Buttermilk.this, "Quantity cannot be less than '0'", Toast.LENGTH_SHORT).show();
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
                buttermilkqty= (Integer.parseInt(binding.editquantity.getText().toString()));
                Data data=Data.getInstance();
                data.setButtermilkqt(buttermilkqty);

            }
        });

    }
}