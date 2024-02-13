package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.banking.R;
import com.example.banking.utils.CreditCardUtils;

public class CreditCardPayment extends AppCompatActivity {
    EditText etCreditCardNumber;
    EditText etCreditCardHolderName;
    TextView tvCreditCardDisplay;
    TextView tvCreditCardDisplayName;

    ImageView ivCardTypeIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_payment);

        etCreditCardNumber = findViewById(R.id.etCreditCardNumber);
        tvCreditCardDisplay = findViewById(R.id.tvCreditCardDisplay);
        ivCardTypeIcon = findViewById(R.id.ivCardTypeIcon);
        etCreditCardHolderName = findViewById(R.id.etCreditCardHolderName);
        tvCreditCardDisplayName = findViewById(R.id.tvCreditCardDisplayName);

        etCreditCardNumber.addTextChangedListener(textWatcher);
        etCreditCardHolderName.addTextChangedListener(textWatcher1);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            String cardNumber = s.toString().replaceAll("\\s+", ""); // Remove any spaces
            updateCardTypeIcon(cardNumber);
            formatCreditCardNumber(s);

            // Update the TextView with the entered credit card number
            tvCreditCardDisplay.setText(formatCreditCardForDisplay(s.toString()));
        }
    };

    private void updateCardTypeIcon(String cardNumber) {
        String cardType = CreditCardUtils.getCardType(cardNumber);
        int iconResId = R.drawable.baseline_credit_card_24; // Default icon

        if (cardType.equals("Visa")) {
            iconResId = R.drawable.ic_visa;
        } else if (cardType.equals("Mastercard")) {
            iconResId = R.drawable.ic_mastercard;
        }

        etCreditCardNumber.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, iconResId, 0);
        ivCardTypeIcon.setImageResource(iconResId);
    }

    private void formatCreditCardNumber(Editable s) {
        String input = s.toString();
        if (!input.isEmpty()) {
            // Remove any spaces from the input
            String cleanInput = input.replaceAll("\\s+", "");
            StringBuilder formattedInput = new StringBuilder();
            for (int i = 0; i < cleanInput.length(); i++) {
                formattedInput.append(cleanInput.charAt(i));
                if ((i + 1) % 4 == 0 && i != cleanInput.length() - 1) {
                    formattedInput.append(" ");
                }
            }
            // Update the EditText with the formatted input
            etCreditCardNumber.removeTextChangedListener(textWatcher);
            s.replace(0, s.length(), formattedInput.toString());
            etCreditCardNumber.addTextChangedListener(textWatcher);
        }
    }

    private String formatCreditCardForDisplay(String cardNumber) {
        // Format the credit card number for display as "xxxx xxxx xxxx xxxx"
        StringBuilder formattedNumber = new StringBuilder();
        int index = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            if (cardNumber.charAt(i) == 'x') {
                if (index < etCreditCardNumber.length()) {
                    formattedNumber.append(etCreditCardNumber.getText().charAt(index));
                    index++;
                } else {
                    formattedNumber.append('x');
                }
            } else {
                formattedNumber.append(cardNumber.charAt(i));
            }
        }
        return formattedNumber.toString();
    }

    private  TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String name = s.toString();
        tvCreditCardDisplayName.setText(name);
        }
    };
}
