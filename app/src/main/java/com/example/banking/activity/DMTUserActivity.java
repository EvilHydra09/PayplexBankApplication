package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.banking.R;
import com.example.banking.adapter.DMTPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DMTUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmtuser);

        TabLayout tabLayout = findViewById(R.id.dmt_tab_layout);
        ViewPager2 viewPager = findViewById(R.id.tab_viewpager);

        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String cNumber = intent.getStringExtra("cNumber");
                Toast.makeText(DMTUserActivity.this, "Dmt:"+cNumber, Toast.LENGTH_SHORT).show();
                Intent intentToC = new Intent(getApplicationContext(), AddBeneficiaryActivity.class);
                intentToC.putExtra("cNumber",cNumber);
                startActivity(intentToC);

            }
        });

        // Create and set the adapter for the ViewPager2
        DMTPagerAdapter pagerAdapter = new DMTPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // Connect the TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Beneficiary");
                            break;
                        case 1:
                            tab.setText("Transaction History");
                            break;
                    }
                }
        ).attach();
    }
}
