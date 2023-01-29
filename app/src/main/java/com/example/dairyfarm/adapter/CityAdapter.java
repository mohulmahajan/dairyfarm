package com.example.dairyfarm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.CityLayoutBinding;
import com.example.dairyfarm.model.City;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{
    Context context;
    ArrayList<City> city;

    public CityAdapter(Context context ,ArrayList<City> city){
        this.context=context;
        this.city=city;


    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(LayoutInflater.from(context).inflate(R.layout.city_layout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City place = city.get(position);
        holder.binding.cityname.setText(place.getName());
        Glide.with(context)
                .load(place.getIcon())
                .into(holder.binding.cityimage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CityViewHolder extends RecyclerView.ViewHolder{
        CityLayoutBinding binding;
        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CityLayoutBinding.bind(itemView);
        }
    }
}