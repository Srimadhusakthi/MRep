package com.mrep.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mrep.doctor.fragment.DoctorBaseFragment;

import java.util.Calendar;

public class DoctorBaseActivity extends AppCompatActivity implements  DoctorBaseFragment.onFragmentInteractions {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    public void onShowToast(Activity activity,String mTitle) {
        Toast.makeText(activity, mTitle, Toast.LENGTH_SHORT).show();
    }


    public String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH) + 1, time.get(Calendar.DAY_OF_MONTH));
    }


    @Override
    public void onFragmentInteractions(int viewType, String mTitle) {

    }
}
