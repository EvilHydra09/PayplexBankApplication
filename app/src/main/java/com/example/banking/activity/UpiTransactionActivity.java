package com.example.banking.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback; // Import the OnBackPressedCallback class

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banking.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class UpiTransactionActivity extends AppCompatActivity {

    TextInputEditText editText;
    private AlertDialog alertDialog;
    Button button, button2, button3, button4, button5, button6, send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi_transaction);
        button = findViewById(R.id.button_200);
        button2 = findViewById(R.id.button_300);
        button3 = findViewById(R.id.button_500);
        button4 = findViewById(R.id.button_1K);
        button5 = findViewById(R.id.button_5K);
        button6 = findViewById(R.id.button_10K);
        editText = findViewById(R.id.edit_rupees);
        send = findViewById(R.id.send_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 200; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 300; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 500; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 1000; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 5000; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textToSet = 10000; // Replace this with the text you want to set
                editText.setText(String.valueOf(textToSet));
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(UpiTransactionActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.qr_dialog_box, null);
                builder.setView(dialogView);

                // Make the dialog not dismiss on touch outside
                builder.setCancelable(true);

                ImageView dialogImage = dialogView.findViewById(R.id.dialogImage);

                // dialogImage.setImageResource(R.drawable.your_image);
                TextView title = dialogView.findViewById(R.id.dialogTitle);
                title.setText("₹" + text);

                // Set up other dialog properties as needed

                // Create the AlertDialog
                alertDialog = builder.create();

                // Show the dialog
                alertDialog.show();

                // Start a timer (example: countdown timer for 10 seconds)
                new CountDownTimer(20000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        // Update the timer text
                        TextView timerText = dialogView.findViewById(R.id.timerText);
                        timerText.setText(String.format(Locale.getDefault(), "%02d:%02d",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        // Timer finished, dismiss the dialog
                        alertDialog.dismiss();
                    }
                }.start();
            }
        });

    }
}
