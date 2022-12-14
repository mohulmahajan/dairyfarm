package com.example.dairyfarm.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dairyfarm.ProfilePage;
import com.example.dairyfarm.R;
import com.example.dairyfarm.model.UserModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProducerAdapter extends RecyclerView.Adapter<ProducerAdapter.MyViewHolder>    {

    private Context context;
    private List<UserModel> userlist;
    StorageReference storageReference;
    public ProducerAdapter(Context context) {
        userlist=new ArrayList<>();
        this.context = context;
    }

    public void addProducer(UserModel userModel){

        userlist.add(userModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.producer_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserModel userModel=userlist.get(position);
        holder.Name.setText(userModel.getName());
        holder.City.setText(userModel.getLoc());
        holder.Products.setText("To Do");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, ProfilePage.class);
                intent.putExtra("model",userModel);
                context.startActivity(intent);
            }
        });

        storageReference= FirebaseStorage.getInstance().getReference("images/" + userModel.getEmail().toString());
        try {
            File localFile= File.createTempFile("tempFile",".jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            holder.Dp.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        ;
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView Name,City,Products;
        private ImageView Dp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.producername);
            City=itemView.findViewById(R.id.producercity);
            Products=itemView.findViewById(R.id.producerproduct);
            Dp=itemView.findViewById(R.id.producerdp);
        }


    }


}
