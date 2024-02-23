package com.example.banking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.banking.Domain.TransactionDomain;
import com.example.banking.R;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.Viewholder> {

    ArrayList<TransactionDomain> domainArrayList ;
    Context context;

    public TransactionAdapter(ArrayList<TransactionDomain> domainArrayList) {
        this.domainArrayList = domainArrayList;
    }

    @NonNull
    @Override
    public TransactionAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        context = parent.getContext();
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.Viewholder holder, int position) {
    holder.tv_trans_amount.setText("₹"+domainArrayList.get(position).getTv_trans_amount());
    holder.tv_trans_refNo.setText(domainArrayList.get(position).getTv_trans_refNo());
    holder.tv_trans_name.setText(domainArrayList.get(position).getTv_trans_name());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(domainArrayList.get(position).getIc_trans_status(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.ic_trans_status);
    }

    @Override
    public int getItemCount() {
        return domainArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tv_trans_amount, tv_trans_refNo,tv_trans_name,tv_trans_date;
        ImageView ic_trans_status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_trans_amount = itemView.findViewById(R.id.bn_bankname);
            tv_trans_refNo = itemView.findViewById(R.id.tv_trans_refNo);
            tv_trans_name = itemView.findViewById(R.id.tv_trans_name);
            tv_trans_date = itemView.findViewById(R.id.tv_trans_date);
            ic_trans_status = itemView.findViewById(R.id.ic_trans_status);
        }
    }
}
