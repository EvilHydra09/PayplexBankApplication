package com.example.banking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banking.Domain.BeneficiaryDomain;
import com.example.banking.R;
import com.example.banking.activity.TransferMoneyActivity;

import java.util.ArrayList;

public class BeneficiaryAdapter extends RecyclerView.Adapter<BeneficiaryAdapter.Viewholder> {

    ArrayList<BeneficiaryDomain>domainArrayList;
    Context context;

    public BeneficiaryAdapter(ArrayList<BeneficiaryDomain> domainArrayList) {
        this.domainArrayList = domainArrayList;
    }

    @NonNull
    @Override
    public BeneficiaryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beneficiary_item, parent, false);
        context = parent.getContext();
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeneficiaryAdapter.Viewholder holder, int position) {
        BeneficiaryDomain data = domainArrayList.get(position);
        holder.name.setText(domainArrayList.get(position).getName());
        holder.AcNO.setText(domainArrayList.get(position).getAcNo());
        holder.BankName.setText(domainArrayList.get(position).getBankName());
        holder.bt_sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TransferMoneyActivity.class);
                intent.putExtra("name",data.getName());
                intent.putExtra("account",data.getAcNo());
                intent.putExtra("Bank",data.getBankName());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return domainArrayList.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{

        TextView name , AcNO , BankName;
        Button bt_sendmoney;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bn_name);
            AcNO = itemView.findViewById(R.id.bn_acno);
            BankName = itemView.findViewById(R.id.bn_bankname);
            bt_sendmoney = itemView.findViewById(R.id.bt_sendmoney);
        }
    }
}
