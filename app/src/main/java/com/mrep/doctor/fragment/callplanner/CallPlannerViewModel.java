package com.mrep.doctor.fragment.callplanner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallPlannerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CallPlannerViewModel(String week) {
        mText = new MutableLiveData<>();
        mText.setValue("This is call planner fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}