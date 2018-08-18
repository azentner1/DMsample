package com.example.sample.devicemagicsample.contract;

public class MainContract {

    public interface Presenter {
        void fetchDownloadItems();
    }

    public interface View {
        void refreshData();
    }
}
