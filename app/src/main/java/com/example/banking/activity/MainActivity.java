package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.banking.Domain.IconDomain;
import com.example.banking.Domain.CardDomain;
import com.example.banking.R;
import com.example.banking.adapter.BankServiceAdapter;
import com.example.banking.adapter.BillAdapter;
import com.example.banking.adapter.CardAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter billAdapter;
    private RecyclerView.Adapter bankServiceAdapter;
    private RecyclerView billRecyclerView;
    private RecyclerView bankServiceRecyclerView;
    
    private ViewPager viewPager;
    private CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        cardViewPager();
        bankRecyclerView();
        billRecyclerView();
    }

    private void bankRecyclerView() {
        bankServiceRecyclerView = findViewById(R.id.bank_recyclerview);
        ArrayList<IconDomain> items = new ArrayList<>();
        items.add(new IconDomain("ICICI AEPS", "icici"));
        items.add(new IconDomain("Paytm AEPS", "paytm"));
        items.add(new IconDomain("City Union Bank AEPS", "citibank"));
        items.add(new IconDomain("MATM", "matm"));
        items.add(new IconDomain("Paytm Money Transfer", "paytm"));
        items.add(new IconDomain("Money Transfer", "money_transfer"));
        items.add(new IconDomain("Account Opening", "account_opening"));
        items.add(new IconDomain("UPI Transaction", "upi"));
        items.add(new IconDomain("CMS", "cms"));
        items.add(new IconDomain("Aadhar Pay", "aadhaar_1"));
        items.add(new IconDomain("Credit Card Bill Payment", "cc_payment"));




        bankServiceAdapter = new BankServiceAdapter(items);
        bankServiceRecyclerView.setLayoutManager(new GridLayoutManager(this, 4,GridLayoutManager.VERTICAL,false));
        bankServiceRecyclerView.setAdapter(bankServiceAdapter);
    }

    private void cardViewPager() {
        viewPager = findViewById(R.id.viewpager2);
        ArrayList<CardDomain> cardDomains = new ArrayList<>();
        cardDomains.add(new CardDomain("Abhidnya Sonawane", "5421 7867 1432 8989", "card_bg_img", "01/27",R.drawable.card_bg_img));
        cardDomains.add(new CardDomain("Atharva Sonawane", "5324 2222 3333 4444", "card_bg_img1", "03/29",R.drawable.card_bg_img1));
        cardDomains.add(new CardDomain("Basant Bhagat", "4312 13431 3333 4444", "card_bg_img2", "11/28",R.drawable.card_bg_img5));

        adapter = new CardAdapter(this, cardDomains);
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }


    private void billRecyclerView() {
        billRecyclerView = findViewById(R.id.bill_recycler_view);

        ArrayList<IconDomain> items = new ArrayList<>();
        items.add(new IconDomain("Mobile \nRecharge", "phone"));
        items.add(new IconDomain("DTH", "signal"));
        items.add(new IconDomain("FastTag", "fastag"));
        items.add(new IconDomain("Electricity \n Bill", "light_bulb"));
        items.add(new IconDomain("Credit \n Card \n Payment", "credit_card"));

        billAdapter = new BillAdapter(items);
        billRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        billRecyclerView.setAdapter(billAdapter);


    }
}