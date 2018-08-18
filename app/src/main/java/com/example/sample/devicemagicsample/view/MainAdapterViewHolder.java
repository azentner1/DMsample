package com.example.sample.devicemagicsample.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sample.devicemagicsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapterViewHolder extends RecyclerView.ViewHolder implements IAdapterRow {

    @BindView(R.id.txtMainAdapterItemValue)
    TextView txtMainAdapterItemValue;

    public MainAdapterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    @Override
    public void setPhrase(String phrase) {
        txtMainAdapterItemValue.setText(phrase);
    }
}
