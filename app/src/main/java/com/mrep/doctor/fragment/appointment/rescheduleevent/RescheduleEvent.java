package com.mrep.doctor.fragment.appointment.rescheduleevent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mrep.R;
import com.mrep.doctor.dialog.DeleteTimeSlotDialog;
import com.mrep.doctor.fragment.DoctorBaseFragment;

public class RescheduleEvent extends DoctorBaseFragment implements View.OnClickListener {
    private View view = null;
    private TextInputEditText event_date;
    private TextInputLayout event_date_layout;
    private String mSelectedDate = "";
    private MaterialButton btn_cancel_time_slot, btn_modify;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_appointment_reschedule_event, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onFindView() {
        event_date = view.findViewById(R.id.event_date);
        event_date_layout = view.findViewById(R.id.event_date_layout);
        btn_cancel_time_slot = view.findViewById(R.id.btn_cancel_time_slot);
        btn_modify = view.findViewById(R.id.btn_modify);
    }

    private void onClickListener() {
        event_date_layout.setOnClickListener(this);
        btn_cancel_time_slot.setOnClickListener(this);
        btn_modify.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.reschedule_event));
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.reschedule_event));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_date_layout:
                onDatePickerDialog(activity);
                break;
            case R.id.btn_cancel_time_slot:
                DeleteTimeSlotDialog deleteTimeSlotDialog =new DeleteTimeSlotDialog();
                deleteTimeSlotDialog.show(activity.getSupportFragmentManager(),getResources().getString(R.string.delete_appointment));
                break;
            case R.id.btn_modify:
                activity.navController.navigate(R.id.action_reschedule_event_to_modify_event);
                break;
            default:
                break;
        }
    }


}
