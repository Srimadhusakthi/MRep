package com.mrep.representative.fragment.doctorlist.doctordetail;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.doctor.dialog.DeleteTimeSlotDialog;
import com.mrep.representative.adapter.doctorlist.PendingDoctorAdapter;
import com.mrep.representative.dialog.BookAppointmentDialog;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DoctorDetailFragment extends RepresentativeBaseFragment implements View.OnClickListener {

    private View view = null;
    private WeekView mCalenderView;
    private MaterialButton btn_view_calendar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctor_doctor_details, container, false);
        onFindView();
        onClickListener();
        return view;
    }


    private void onFindView() {
        btn_view_calendar = view.findViewById(R.id.btn_view_calendar);
    }

    private void onClickListener() {
        btn_view_calendar.setOnClickListener(this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.doctor_details));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.doctor_details));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_calendar:
                activity.navController.navigate(R.id.action_doctor_details_to_appointment_calendar);
                break;
        }
    }
}

