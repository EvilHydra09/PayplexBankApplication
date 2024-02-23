package com.example.banking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.banking.Domain.IconDomain;
import com.example.banking.R;
import com.example.banking.activity.FastagActivity;
import com.example.banking.activity.MobileRechargeActivity;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    ArrayList<IconDomain> billDomainArrayList;

    public BillAdapter(ArrayList<IconDomain> billDomainArrayList) {
        this.billDomainArrayList = billDomainArrayList;
    }

    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(billDomainArrayList.get(position).getName());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(billDomainArrayList.get(position).getImgpath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);


        holder.itemView.setOnClickListener(v -> {
            // Handle item click here, launch different activities based on the item clicked
            switch (position) {
                case 0:
                    Intent intent = new Intent(context, MobileRechargeActivity.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, FastagActivity.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, FastagActivity.class);
                    context.startActivity(intent);
                    break;
                // Add more cases for additional activities as needed
                default:
                    break;
            }
            // Add more conditions for additional activities as needed
        });    }

    @Override
    public int getItemCount() {
        return billDomainArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bill_text);
            pic = itemView.findViewById(R.id.bill_img);
        }
    }
}
