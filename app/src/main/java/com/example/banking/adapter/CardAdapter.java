package com.example.banking.adapter;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.banking.Domain.CardDomain;
import com.example.banking.R;

import java.util.ArrayList;

public class CardAdapter extends PagerAdapter {

    Context context;
    ArrayList<CardDomain> cardDomains;

    public CardAdapter(Context context, ArrayList<CardDomain> cardDomains) {
        this.context = context;
        this.cardDomains = cardDomains;
    }

    @Override
    public int getCount() {
        return cardDomains.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,null);
        TextView cardName = view.findViewById(R.id.cardName);
        TextView cardNo = view.findViewById(R.id.cardNo);
        TextView cardDate = view.findViewById(R.id.cardDate);
        ConstraintLayout constraintLayout = view.findViewById(R.id.cardimg);

        cardName.setText(cardDomains.get(position).getCardname());
        cardNo.setText(cardDomains.get(position).getCardno());
        cardDate.setText(cardDomains.get(position).getCarddate());

        CardDomain model = cardDomains.get(position);

        // Load image using Glide and set it as background
        Glide.with(context)
                .load(model.getDrawableResourceId())
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        constraintLayout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        // this is called when imageView is cleared on lifecycle call or for
                        // some other reason.
                        // if you are referencing the drawable you can null it out here
                    }
                });

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
