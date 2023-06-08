package com.example.dairyfarm.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dairyfarm.R;
import com.example.dairyfarm.databinding.ActivityCartBinding;
import com.example.dairyfarm.ques.Data;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
        ActivityCartBinding binding;
        private RecyclerView recyclerView;
        private List<cartlist> carts;
        private int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        recyclerView=(RecyclerView) findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        carts= new ArrayList<>();
        Data data=Data.getInstance();
        if (data.getMilkqt()>0){cartlist cartlist= new cartlist();

            cartlist.setItem("Milk");
            cartlist.setPrice(65*data.getMilkqt());
            cartlist.setQty(data.getMilkqt());
            total=total+(65*data.getMilkqt());
            carts.add(cartlist);

        }
         if (data.getButterqt()>0){
            cartlist cartlist= new cartlist();

            cartlist.setItem("Butter");
            cartlist.setPrice(50*data.getButterqt());
            cartlist.setQty(data.getButterqt());
            total=total+(50*data.getButterqt());
             carts.add(cartlist);

        } if (data.getButtermilkqt()>0){
            cartlist cartlist= new cartlist();

            cartlist.setItem("ButterMilk");
            cartlist.setPrice(40*data.getButtermilkqt());
            cartlist.setQty(data.getButtermilkqt());
            total=total+(40*data.getButtermilkqt());
            carts.add(cartlist);

        } if (data.getCheeseqt()>0){
            cartlist cartlist= new cartlist();

            cartlist.setItem("Cheese");
            cartlist.setPrice(500*data.getCheeseqt());
            cartlist.setQty(data.getCheeseqt());
            total=total+(500*data.getCheeseqt());
            carts.add(cartlist);

        } if (data.getCurdqt()>0){
            cartlist cartlist= new cartlist();

            cartlist.setItem("Curd");
            cartlist.setPrice(72*data.getCurdqt());
            cartlist.setQty(data.getCurdqt());
            total=total+(72*data.getCurdqt());
            carts.add(cartlist);

        } if (data.getPaneerqt()>0){
            cartlist cartlist= new cartlist();

            cartlist.setItem("Paneer");
            cartlist.setPrice(360*data.getPaneerqt());
            cartlist.setQty(data.getPaneerqt());
            total=total+(360*data.getPaneerqt());
            carts.add(cartlist);

        }
//        Log.d("list", String.valueOf(carts));

        recyclerView.setAdapter(new cartAdapter(carts));
    }

class cartAdapter extends RecyclerView.Adapter<cartViewHolder>{
        private Context context;
        private List<cartlist >carts;

    public cartAdapter(Context context, List<cartlist> carts) {
        this.context = context;
        this.carts = carts;
    }

    public cartAdapter(List<cartlist> carts) {
        this.carts = carts;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cartViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {
        holder.bind(this.carts.get(position));
    }

    @Override
    public int getItemCount() {
        return this.carts.size();
    }
}
    class cartViewHolder extends RecyclerView.ViewHolder{
        private TextView item,qty,price;
        private ImageView img;
        public cartViewHolder(ViewGroup container) {
            super(LayoutInflater.from(Cart.this).inflate(R.layout.cartlist,container,false));
            item=itemView.findViewById(R.id.itemlist);
            qty=itemView.findViewById(R.id.qtylist);
            price=itemView.findViewById(R.id.pricelist);
            img=itemView.findViewById(R.id.imglist);
//            item=(TextView) findViewById(R.id.itemlist);
//            qty=(TextView) findViewById(R.id.qtylist);
//            price=(TextView) findViewById(R.id.pricelist);
//            img= (ImageView) findViewById(R.id.imglist);
        }
        public void bind(cartlist carlist){

            item.setText(carlist.getItem());
            qty.setText(carlist.getQty());
            price.setText(carlist.getPrice());
//            img.setImageResource(Integer.parseInt(carlist.getImg()));

        }
    }
}
class cartlist{
    private String item ="";
    private int price=0;
    private int qty=0;


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}