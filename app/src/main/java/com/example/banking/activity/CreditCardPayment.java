package com.example.banking.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banking.R;
import com.example.banking.utils.CreditCardUtils;

public class CreditCardPayment extends AppCompatActivity {
    EditText etCreditCardNumber;
    EditText etCreditCardHolderName;
    TextView tvCreditCardDisplay;
    TextView tvCreditCardDisplayName;

    ImageView ivCardTypeIcon;


    Button button;
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

        button = findViewById(R.id.bt_send_otp);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String CardNumber = etCreditCardNumber.getText().toString();
                String CardName = etCreditCardHolderName.getText().toString();
                String cleanInput = CardNumber.replaceAll("\\s+", "");
                Toast.makeText(CreditCardPayment.this,CardName+"\n"+cleanInput, Toast.LENGTH_SHORT).show();
                showOtpDialog();
            }
        });


    }

    private void showOtpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_otp_input, null);

        // Initialize EditText fields
        EditText[] editTexts = new EditText[6];
        for (int i = 0; i < 6; i++) {
            int resID = getResources().getIdentifier("inputotp" + (i + 1), "id", getPackageName());
            editTexts[i] = dialogView.findViewById(resID);

            final int index = i;
            editTexts[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 1 && index < 5) {
                        editTexts[index + 1].requestFocus();
                    } else if (s.length() == 0 && index > 0) {
                        editTexts[index - 1].requestFocus();
                    }
                }
            });

            editTexts[i].setOnKeyListener((v, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN && index > 0) {
                    editTexts[index - 1].requestFocus();
                    editTexts[index - 1].setText("");
                    return true;
                }
                return false;
            });
        }

        // Handle "Resend OTP" button
        TextView buttonResendOTP = dialogView.findViewById(R.id.textresendotp);
        buttonResendOTP.setOnClickListener(v -> {
            // Implement resend OTP logic here
            Toast.makeText(CreditCardPayment.this, "Resend OTP", Toast.LENGTH_SHORT).show();
        });

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();

        Button buttonSubmit = dialogView.findViewById(R.id.buttongetotp);
        buttonSubmit.setOnClickListener(v -> {
            StringBuilder otpBuilder = new StringBuilder();
            for (EditText editText : editTexts) {
                otpBuilder.append(editText.getText().toString());
            }
            String otp = otpBuilder.toString();
            Toast.makeText(CreditCardPayment.this, "OTP: " + otp, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
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
