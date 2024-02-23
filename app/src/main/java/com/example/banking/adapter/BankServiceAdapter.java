package com.example.banking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.banking.Domain.IconDomain;
import com.example.banking.R;
import com.example.banking.activity.ComingSoonActivity;
import com.example.banking.activity.CreditCardPayment;
import com.example.banking.activity.MAtmActivity;
import com.example.banking.activity.MAtmTransaction;
import com.example.banking.activity.MainActivity;
import com.example.banking.activity.MoneyTransferActivity;
import com.example.banking.activity.ProfileActivity;
import com.example.banking.activity.TestActivity;
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                    LayoutInflater inflater = LayoutInflater.from(holder.itemView.getContext());
                    View dialogView = inflater.inflate(R.layout.aeps_dialog_box, null);
                    builder.setView(dialogView);

                    RecyclerView recyclerView = dialogView.findViewById(R.id.rc_apes);
                    ArrayList<IconDomain> items = new ArrayList<>();
                    items.add(new IconDomain("ICICI AEPS", "icici"));
                    items.add(new IconDomain("Paytm AEPS", "paytm"));
                    items.add(new IconDomain("City Union Bank AEPS", "citibank"));

                    AEPSAdapter adapter = new AEPSAdapter(items);
                    recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
                    recyclerView.setAdapter(adapter);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                case 1:
                    Intent intent = new Intent(context, MAtmActivity.class);
                      context.startActivity(intent);
                    break;
                case 2:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(holder.itemView.getContext());
                    LayoutInflater inflater1 = LayoutInflater.from(holder.itemView.getContext());
                    View dialogView1 = inflater1.inflate(R.layout.aeps_dialog_box, null);
                    builder1.setView(dialogView1);

                    RecyclerView recyclerView1 = dialogView1.findViewById(R.id.rc_apes);
                    ArrayList<IconDomain> items1 = new ArrayList<>();
                    items1.add(new IconDomain("Paytm Money Transfer", "paytm"));
                    items1.add(new IconDomain("Direct Money Transfer", "money_transfer"));
                    MoneyTransferAdapter adapter1 = new MoneyTransferAdapter(items1);
                    recyclerView1.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
                    recyclerView1.setAdapter(adapter1);
                    AlertDialog alertDialog1 = builder1.create();
                    alertDialog1.show();
                    break;
                case 3:
                    intent = new Intent(context, ComingSoonActivity.class);
                    context.startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(context, UpiTransactionActivity.class);
                    context.startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, ProfileActivity.class);
                    context.startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(context, TestActivity.class);
                    context.startActivity(intent);
                    break;
                case 7:
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
