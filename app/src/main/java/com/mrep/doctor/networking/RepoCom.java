package com.mrep.doctor.networking;



public interface RepoCom<T> {
    void onRepoComError(int errorMsg);

    void onRepoComLoading();

    void onRepoComSuccess(T object);

}
