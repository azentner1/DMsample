package com.example.sample.devicemagicsample.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sample.devicemagicsample.App;
import com.example.sample.devicemagicsample.R;
import com.example.sample.devicemagicsample.presenter.MainPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapterViewHolder> {

    private MainPresenter presenter;

    public MainAdapter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_adapter_item, parent, false);
        ButterKnife.bind(this, view);
        return new MainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapterViewHolder holder, int position) {
        presenter.onBindRowPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getPhraseCount();
    }
}
