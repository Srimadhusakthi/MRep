package com.mrep.doctor.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.NavDirections;

import com.mrep.utils.Debugger;


public class BaseViewModel extends AndroidViewModel {

    public final Debugger debugger = new Debugger(this);

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public interface UiInteractor {
        void showToast(int msg, int length);

        void hideSoftKeyboard();

    }


    public interface FragmentUIInteractor extends ActivityUIInteractor {

    }

    public interface ActivityUIInteractor extends UiInteractor {
        void navigate(int action, Bundle bundle, View[] views);
        void navigate(NavDirections action, View[] views);
        void navigateBack();

        void openDialer(String mobileNumber);
    }

    public interface DialogUIInteractor extends FragmentUIInteractor {
    }

}
