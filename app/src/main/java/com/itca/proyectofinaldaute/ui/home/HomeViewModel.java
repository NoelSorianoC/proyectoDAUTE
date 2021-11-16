package com.itca.proyectofinaldaute.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Manuel de Jesus Gamez Lopez");
    }

    public LiveData<String> getText() {
        return mText;
    }
}