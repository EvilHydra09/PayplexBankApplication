package com.example.banking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.banking.R;

public class FastagActivity extends AppCompatActivity {
    String[] item = {"Icici Bank","Maharashtra Bank","HDFC Bank","Kodak Bank"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastag);



        autoCompleteTextView = findViewById(R.id.autoCompleteBank);
        adapterItems = new ArrayAdapter<String>( this, R.layout.list_view,item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(FastagActivity.this,"Item: ,"+item, Toast.LENGTH_SHORT).show();
            }


        });
    }
}