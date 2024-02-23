package com.example.banking.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.example.banking.R;

public class IciciActivity extends AppCompatActivity {
    private AppCompatButton button1;
    private AppCompatButton button2;
    private AppCompatButton button3;
    LinearLayout balance, miniStatement, cashWithdraw;
    ScrollView do2fa, cashWithdrawalForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icici);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        balance = findViewById(R.id.llbalanceEnquiry);
        miniStatement = findViewById(R.id.llMiniStatement);
        cashWithdraw = findViewById(R.id.llCashWithdrawal);
        do2fa = findViewById(R.id.do2fa);
        cashWithdrawalForm = findViewById(R.id.cashwithdrawalform);

        // Highlight the first button initially
        highlightButton(button1);

        // Set click listeners for all buttons
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlightButton(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlightButton(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlightButton(button3);
            }
        });

        // Set click listener for DO 2FA button
        AppCompatButton do2faButton = findViewById(R.id.do2faButton);
        do2faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do2fa.setVisibility(View.GONE);
                cashWithdrawalForm.setVisibility(View.VISIBLE);
            }
        });
    }

    private void highlightButton(AppCompatButton button) {
        // Reset background color of all buttons
        button1.setBackgroundColor(Color.WHITE);
        button2.setBackgroundColor(Color.WHITE);
        button3.setBackgroundColor(Color.WHITE);

        // Reset visibility of all LinearLayouts
        balance.setVisibility(View.GONE);
        miniStatement.setVisibility(View.GONE);
        cashWithdraw.setVisibility(View.GONE);

        // Highlight the clicked button
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue));

        // Show the corresponding LinearLayout
        if (button == button1) {
            balance.setVisibility(View.VISIBLE);
        } else if (button == button2) {
            miniStatement.setVisibility(View.VISIBLE);
        } else if (button == button3) {
            cashWithdraw.setVisibility(View.VISIBLE);
        }
    }

    public void onButtonClick(View view) {
        AppCompatButton button = (AppCompatButton) view;
        highlightButton(button);
    }
}
