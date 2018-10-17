package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.sunshine.data.SunshineRepository;

public class MainActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private SunshineRepository sunshineRepository;

    public MainActivityViewModelFactory(SunshineRepository sunshineRepository) {
        this.sunshineRepository = sunshineRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainActivityViewModel(sunshineRepository);
    }
}
