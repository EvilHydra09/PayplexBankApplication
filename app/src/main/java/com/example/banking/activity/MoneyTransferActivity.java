package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import com.example.banking.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MoneyTransferActivity extends AppCompatActivity {
    TextInputEditText datepicker,search_phone,fix_phone_no;

    LinearLayout createuser;
    Button search_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);

        datepicker = findViewById(R.id.date_picker_actions);
        search_button = findViewById(R.id.search_user_button);
        search_phone = findViewById(R.id.search_phone_no);
        createuser = findViewById(R.id.create_linear_layout);
        fix_phone_no = findViewById(R.id.fix_phone_no);
        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createuser.setVisibility(View.VISIBLE);
                String text = search_phone.getText().toString();
                fix_phone_no.setText(text);




            }
        });




    }
    private void showDatePickerDialog() {
        // Get current date to pre-fill the DatePickerDialog
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // When a date is selected, format it and set it to EditText
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String selectedDateFormatted = dateFormat.format(selectedDate.getTime());
                        datepicker.setText(selectedDateFormatted);
                    }
                }, year, month, dayOfMonth);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}