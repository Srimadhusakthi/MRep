package com.mrep.doctor.repository;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.mrep.doctor.networking.RepoCom;
import com.mrep.utils.Debugger;


public abstract class BaseRepository {

    Debugger debugger = new Debugger(this);
    Context context;

    public BaseRepository(Context context) {
        this.context = context;
    }

    public final static MutableLiveData<Boolean> internetConnectionAvailable = new MutableLiveData<>();


    public final void setResult(RepoCom repoCom, Object result) {
        if (repoCom == null) return;
        if (result != null)
            debugger.logD("its a success result :- " + result.toString());
        else
            debugger.logD("its a success result :- null");

        repoCom.onRepoComSuccess(result);
    }

    public final void setError(RepoCom repoCom, int msg) {
        if (repoCom == null) return;
        debugger.logD("its an error msg :- " + msg);

        repoCom.onRepoComError(msg);
    }


    public final void setLoading(RepoCom repoCom) {
        if (repoCom == null) return;
        debugger.logD("started loading");
        repoCom.onRepoComLoading();
    }


    public static void setInternetConnectionAvailableFromBroadCastReciver(boolean available) {
        internetConnectionAvailable.setValue(available);
    }


}
