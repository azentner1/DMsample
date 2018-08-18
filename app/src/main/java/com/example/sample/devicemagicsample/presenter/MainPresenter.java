package com.example.sample.devicemagicsample.presenter;

import com.example.sample.devicemagicsample.contract.MainContract;
import com.example.sample.devicemagicsample.model.DownloadItem;
import com.example.sample.devicemagicsample.model.FetchDownloadItems;
import com.example.sample.devicemagicsample.model.FetchPhrases;
import com.example.sample.devicemagicsample.model.Phrase;
import com.example.sample.devicemagicsample.view.IAdapterRow;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {


    private MainContract.View view;
    private ArrayList<Phrase> phrasesList;
    private ArrayList<DownloadItem> downloadItems;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchDownloadItems() {
        new FetchDownloadItems().requestDownloadItems(this);
    }

    public void onBindRowPosition(int position, IAdapterRow adapterRow) {
        Phrase phrase = phrasesList.get(position);
        adapterRow.setPhrase(phrase.getValue());
    }

    public int getPhraseCount() {
        return phrasesList != null ? phrasesList.size() : 0;
    }

    private void fetchPhrases(ArrayList<DownloadItem> downloadItems) {
        for (DownloadItem downloadItem : downloadItems) {
            new FetchPhrases().requestPhrase(this, downloadItem.getItem());
        }
    }

    public void setDownloadItems(ArrayList<DownloadItem> downloadItems) {
        this.downloadItems = downloadItems;
        fetchPhrases(downloadItems);
    }

    public void setPhrase(Phrase phrase) {
        if (phrasesList == null) {
            phrasesList = new ArrayList<>();
        }
        phrasesList.add(phrase);
        view.refreshData();
    }
}
