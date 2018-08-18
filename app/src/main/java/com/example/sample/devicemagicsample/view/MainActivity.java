package com.example.sample.devicemagicsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sample.devicemagicsample.R;
import com.example.sample.devicemagicsample.contract.MainContract;
import com.example.sample.devicemagicsample.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.rvMain)
    RecyclerView rvMain;
    @BindView(R.id.pbMain)
    ProgressBar pbMain;

    private MainPresenter presenter;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        initUi();
        initAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.fetchDownloadItems();
    }

    private void initUi() {
        pbMain.setVisibility(View.VISIBLE);
        rvMain.setHasFixedSize(true);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        mainAdapter = new MainAdapter(presenter);
        rvMain.setAdapter(mainAdapter);
    }

    @Override
    public void refreshData() {
        pbMain.setVisibility(View.GONE);
        mainAdapter.notifyDataSetChanged();
    }
}
