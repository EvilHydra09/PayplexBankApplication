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
import com.example.banking.activity.CreditCardPayment;
import com.example.banking.activity.FastagActivity;
import com.example.banking.activity.MAtmActivity;
import com.example.banking.activity.MobileRechargeActivity;
import com.example.banking.activity.MoneyTransferActivity;
import com.example.banking.activity.UpiTransactionActivity;

import java.util.ArrayList;

public class BankServiceAdapter extends RecyclerView.Adapter<BankServiceAdapter.ViewHolder> {

    ArrayList<IconDomain> bankDomains;
    Context context;

    public BankServiceAdapter(ArrayList<IconDomain> bankDomains) {
        this.bankDomains = bankDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(bankDomains.get(position).getName());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(bankDomains.get(position).getImgpath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            // Handle item click here, launch different activities based on the item clicked
            switch (position) {
                case 0:
                    Intent intent = new Intent(context, MoneyTransferActivity.class);
                    context.startActivity(intent);
                    break;
                case 1:
//                    intent = new Intent(context, ThirdActivity.class);
//                      context.startActivity(intent);
//                    break;
                case 2:
                    intent = new Intent(context, FastagActivity.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, MAtmActivity.class);
                    context.startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(context, MAtmActivity.class);
                    context.startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, MoneyTransferActivity.class);
                    context.startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(context, MoneyTransferActivity.class);
                    context.startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(context, UpiTransactionActivity.class);
                    context.startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(context, MoneyTransferActivity.class);
                    context.startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(context, MoneyTransferActivity.class);
                    context.startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(context, CreditCardPayment.class);
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
        return bankDomains.size();
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
