package com.mt.greyfood.ui.campaigns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CampaignsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CampaignsViewModel() {
        this.mText = new MutableLiveData<>();
        mText.setValue("Kampanyalar");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
