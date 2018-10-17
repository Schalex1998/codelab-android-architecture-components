package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.ListWeatherEntry;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private LiveData<List<ListWeatherEntry>> mWeatherEntries;

    MainActivityViewModel(SunshineRepository repository) {
        mWeatherEntries = repository.getCurrentForecasts();
    }

    public LiveData<List<ListWeatherEntry>> getWeatherEntries() {
        return mWeatherEntries;
    }
}
