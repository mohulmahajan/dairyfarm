//package com.example.dairyfarm.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.dairyfarm.R;
//import com.example.dairyfarm.model.ProductModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
//    private List<ProductModel> productModels;
//    private Context context;
//
//    public ProductAdapter(Context context) {
//        this.context = context;
//        productModels= new ArrayList<>();
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_prod_dealsin,parent,false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        ProductModel productModel= productModels.get(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return productModels.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder{
//        private TextView price,title;
//        private ImageView image;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title=itemView.findViewById(R.id.dealsintitle);
//            price=itemView.findViewById(R.id.dealsinprice);
//            image=itemView.findViewById(R.id.dealsinimage);
//        }
//    }
//}
