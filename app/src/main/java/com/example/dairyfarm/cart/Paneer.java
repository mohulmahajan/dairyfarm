package com.example.dairyfarm.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.ActivityMilkBinding;
import com.example.dairyfarm.databinding.ActivityPaneerBinding;
import com.example.dairyfarm.ques.Data;

public class Paneer extends AppCompatActivity {
ActivityPaneerBinding binding;
int qty;
int paneerqty=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityPaneerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.imageView3.setImageResource(R.drawable.paneer);

        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty= Integer.parseInt(binding.editquantity.getText().toString());
                if (qty==0){
                    Toast.makeText(Paneer.this, "Quantity cannot be less than '0'", Toast.LENGTH_SHORT).show();
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
                paneerqty= (Integer.parseInt(binding.editquantity.getText().toString()));
                Data data=Data.getInstance();
                data.setPaneerqt(paneerqty);


            }
        });
    }
}