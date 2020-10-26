package com.mrep.doctor.fragment.callplanner.deletetimeslot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mrep.R;

public class DeleteTimeSlot extends Fragment implements View.OnClickListener {
    private View view = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_appointment, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onClickListener() {

    }

    private void onFindView() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }

    }
}
