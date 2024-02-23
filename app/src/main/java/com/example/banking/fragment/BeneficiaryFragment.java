package com.example.banking.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banking.Domain.BeneficiaryDomain;
import com.example.banking.Domain.TransactionDomain;
import com.example.banking.R;
import com.example.banking.adapter.BeneficiaryAdapter;
import com.example.banking.adapter.TransactionAdapter;

import java.util.ArrayList;


public class BeneficiaryFragment extends Fragment {

    ArrayList<BeneficiaryDomain> domainArrayList;
    BeneficiaryAdapter transactionAdapter;
    RecyclerView recyclerView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beneficiary, container, false);
        recyclerView = view.findViewById(R.id.rc_saved);
        domainArrayList = new ArrayList<>();
        domainArrayList.add(new BeneficiaryDomain("Abhidnya","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Omkar","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Pratik","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Vishal","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Rushi","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Basant","34241123412341","ICICI"));
        domainArrayList.add(new BeneficiaryDomain("Abhidnya","34241123412341","ICICI"));
        transactionAdapter = new BeneficiaryAdapter(domainArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(transactionAdapter);
        return view;
    }
}