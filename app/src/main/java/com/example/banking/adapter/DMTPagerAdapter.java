package com.example.banking.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.banking.fragment.BeneficiaryFragment;
import com.example.banking.fragment.TransactionHistoryFragment;

public class DMTPagerAdapter extends FragmentStateAdapter {
    public DMTPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a new instance of your fragment for each tab
        switch (position) {
            case 0:
                return new BeneficiaryFragment();
            case 1:
                return new TransactionHistoryFragment();
            default:
                throw new IllegalArgumentException("Invalid tab position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        // Return the number of tabs
        return 2;
    }
}

