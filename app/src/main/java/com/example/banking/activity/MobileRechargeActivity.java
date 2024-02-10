package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.banking.Domain.BannerDomain;
import com.example.banking.R;
import com.example.banking.adapter.BannerAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MobileRechargeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BannerAdapter adapter;

    String[] item = {"Airtel","Jio","VI","BSNL"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge);

        viewPager = findViewById(R.id.viewpager2);
        ArrayList<BannerDomain> cardDomains = new ArrayList<>();
        cardDomains.add(new BannerDomain("https://www.adgully.com/img/800/67007_outdoor-1-choose-anything.jpg"));
        cardDomains.add(new BannerDomain("https://etimg.etb2bimg.com/photo/100868646.cms"));
        cardDomains.add(new BannerDomain("https://www.myvi.in/content/dam/vodafoneideadigital/deviceLandingPage/Desk_new_smartphone_offer.png"));

        adapter = new BannerAdapter(this, cardDomains);
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        autoCompleteTextView = findViewById(R.id.autoComplete);
        adapterItems = new ArrayAdapter<String>( this, R.layout.list_view,item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MobileRechargeActivity.this,"Item: ,"+item, Toast.LENGTH_SHORT).show();
            }


        });
    }
}