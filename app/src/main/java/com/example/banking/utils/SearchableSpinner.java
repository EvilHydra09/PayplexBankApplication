package com.example.banking.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.List;

public class SearchableSpinner extends AppCompatSpinner implements TextWatcher {

    private List<String> items;
    private ArrayAdapter<String> adapter;

    public SearchableSpinner(Context context) {
        super(context);
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        setAdapter(adapter);
    }

    public void setItems(List<String> items) {
        this.items.clear();
        this.items.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }

    private void filter(String text) {
        List<String> filteredItems = new ArrayList<>();
        for (String item : items) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        adapter.clear();
        adapter.addAll(filteredItems);
        adapter.notifyDataSetChanged();
    }

}

