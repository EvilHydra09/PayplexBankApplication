package com.example.banking.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banking.Domain.TransactionDomain;
import com.example.banking.R;
import com.example.banking.adapter.TransactionAdapter;

import java.util.ArrayList;


public class TransactionHistoryFragment extends Fragment {
    ArrayList<TransactionDomain> domainArrayList;
    TransactionAdapter transactionAdapter;
    RecyclerView recyclerView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        recyclerView = view.findViewById(R.id.rc_frag_trans);
        domainArrayList = new ArrayList<>();
        domainArrayList.add(new TransactionDomain("1000","321313123","green_tick","Abhidnya Sonawane"));
        domainArrayList.add(new TransactionDomain("2000","321313123","green_tick","Abhidnya Sonawane"));
        domainArrayList.add(new TransactionDomain("3000","321313123","red_cross","Abhidnya Sonawane"));
        domainArrayList.add(new TransactionDomain("4000","321313123","green_tick","Abhidnya Sonawane"));

        transactionAdapter = new TransactionAdapter(domainArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(transactionAdapter);


        return view;
    }
}