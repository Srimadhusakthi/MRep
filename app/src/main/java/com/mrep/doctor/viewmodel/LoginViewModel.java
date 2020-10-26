package com.mrep.doctor.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mrep.R;
import com.mrep.utils.ValidationRules;

public class LoginViewModel extends BaseViewModel {

    UiInteractor fragmentUIInteractor;
    public final MutableLiveData<String> mUserEmail = new MutableLiveData<>();
    public final MutableLiveData<String> mPassword = new MutableLiveData<>();
    public final MutableLiveData<Integer> email_error = new MutableLiveData<>();
    public final MutableLiveData<Integer> password_error = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    public void onSignIn(View view) {
        if (onValidation()) {

        }

    }


    public boolean onValidation() {
        if (!ValidationRules.iSValidEmail(mUserEmail.getValue())) {
            email_error.setValue(R.string.enter_the_email);
            return false;
        } else if (!ValidationRules.iSValidEmail(mUserEmail.getValue())) {
            password_error.setValue(R.string.enter_the_email);
            return false;
        }
        return true;
    }

}
