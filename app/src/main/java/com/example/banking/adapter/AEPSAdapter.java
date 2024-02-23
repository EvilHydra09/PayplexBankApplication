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
import com.example.banking.activity.IciciActivity;
import com.example.banking.activity.MobileRechargeActivity;
import com.example.banking.activity.MoneyTransferActivity;

import java.util.ArrayList;

public class AEPSAdapter extends RecyclerView.Adapter<AEPSAdapter.ViewHolder> {

    ArrayList<IconDomain> billDomainArrayList;
    Context context;

    public AEPSAdapter(ArrayList<IconDomain> billDomainArrayList) {
        this.billDomainArrayList = billDomainArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(billDomainArrayList.get(position).getName());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(billDomainArrayList.get(position).getImgpath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageView);


        holder.itemView.setOnClickListener(v -> {
            // Handle item click here, launch different activities based on the item clicked
            switch (position) {
                case 0:
                    Intent intent = new Intent(context, IciciActivity.class);
                    context.startActivity(intent);
                    break;
                case 1:
                     intent = new Intent(context, IciciActivity.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, IciciActivity.class);
                    context.startActivity(intent);
                    break;
                // Add more cases for additional activities as needed
                default:
                    break;
            }
            // Add more conditions for additional activities as needed
        });
    }


    @Override
    public int getItemCount() {
        return billDomainArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bill_img);
            textView = itemView.findViewById(R.id.bill_text);
        }
    }
}
