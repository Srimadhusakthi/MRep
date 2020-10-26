package com.mrep.doctor.fragment.appointment.modifyappoinment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.doctor.fragment.DoctorBaseFragment;

public class ModifyMrepAppointment extends DoctorBaseFragment implements View.OnClickListener {
    private View view = null;
    private MaterialButton btn_cancel_time_slot, btn_blockRep;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_appointment_modify, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onClickListener() {
        btn_blockRep.setOnClickListener(this);
        btn_cancel_time_slot.setOnClickListener(this);

    }

    private void onFindView() {
        btn_cancel_time_slot = view.findViewById(R.id.btn_cancel_time_slot);
        btn_blockRep = view.findViewById(R.id.btn_blockrep);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel_time_slot:
            case R.id.btn_blockrep:
                activity.onSupportNavigateUp();
                break;
            default:
                break;
        }

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, getString(R.string.modifymrepappointment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, getString(R.string.modifymrepappointment));
    }
}

