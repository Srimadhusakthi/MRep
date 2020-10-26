package com.mrep.doctor.fragment.callplanner.updatetimeslot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.doctor.adapter.WeeklyAdapter;
import com.mrep.doctor.fragment.DoctorBaseFragment;

import java.util.ArrayList;

public class UpdateTimeSlot extends DoctorBaseFragment implements View.OnClickListener, WeeklyAdapter.onSelectedDayListener {
    private View view = null;
    private Spinner repeat_mode, week_month_mode;
    private ArrayAdapter repeatAdapter, mWeekMonthAdapter;
    private WeeklyAdapter weeklyAdapter;
    private RecyclerView rvWeekday_list;
    private RadioButton rbRepeat_date, rbRepeat_day, rbUpdate_repeat_date, rbUpdate_repeat_day;
    private MaterialTextView tvRepeat_occur_date;
    private RadioGroup update_repeat_group, repeat_group;
    private MaterialButton btn_delete_slot, btn_update;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_callplanner_update_timeslot, container, false);
        onFindView();
        onClickListener();
        onRepeatYesNoList();
        onRepeatWeekMonthList();
        onWeeklyAdapterList();
        return view;
    }

    private void onRepeatYesNoList() {
        ArrayList<String> repeatList = new ArrayList<>();
        repeatList.add(activity.getResources().getString(R.string.yes));
        repeatList.add(activity.getResources().getString(R.string.no));
        repeatAdapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, repeatList);
        repeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repeat_mode.setAdapter(repeatAdapter);

        repeat_mode.setSelection(1);
        repeat_mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onCustomLayoutMode(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void onRepeatWeekMonthList() {
        ArrayList<String> weekList = new ArrayList<>();
        weekList.add(activity.getResources().getString(R.string.week));
        weekList.add(activity.getResources().getString(R.string.month));
        mWeekMonthAdapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, weekList);
        mWeekMonthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        week_month_mode.setAdapter(mWeekMonthAdapter);
        week_month_mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onCustomLayoutMode(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void onWeeklyAdapterList() {
        weeklyAdapter = new WeeklyAdapter(activity, weeklyList());
        weeklyAdapter.setCallBack(this);
        rvWeekday_list.setAdapter(weeklyAdapter);

    }

    private void onClickListener() {
        btn_delete_slot.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.update_time_slot));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.addtimeslot));
    }

    private void onFindView() {
        btn_delete_slot = view.findViewById(R.id.btn_delete_slot);
        btn_update = view.findViewById(R.id.btn_update);
        repeat_group = view.findViewById(R.id.repeat_group);
        update_repeat_group = view.findViewById(R.id.update_repeat_group);
        tvRepeat_occur_date = view.findViewById(R.id.repeat_occur_date);
        rbRepeat_date = view.findViewById(R.id.repeat_date);
        rbRepeat_day = view.findViewById(R.id.repeat_day);
        rbUpdate_repeat_date = view.findViewById(R.id.update_repeat_date);
        rbUpdate_repeat_day = view.findViewById(R.id.update_repeat_day);
        repeat_mode = view.findViewById(R.id.repeat_mode);
        week_month_mode = view.findViewById(R.id.week_month_mode);
        rvWeekday_list = view.findViewById(R.id.weekday_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        rvWeekday_list.setLayoutManager(linearLayoutManager);

        rbRepeat_date.setText("On " + getCurrentDate());
        rbRepeat_day.setText("On the " + getPresentDay());
        rbUpdate_repeat_date.setText("Update only this Time Slot");
        rbUpdate_repeat_day.setText("Update all upcoming Time Slot");
        tvRepeat_occur_date.setText("Occurs every week until " + getCurrentDate());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete_slot:
            case R.id.btn_update:
                activity.onSupportNavigateUp();
                break;
            default:
                break;
        }
    }


    @Override
    public void onSelectedDay(String mDay) {
        rbRepeat_day.setText("On the " + mDay);
    }


    private void onCustomLayoutMode(String modeType) {
        if (modeType.equalsIgnoreCase(activity.getResources().getString(R.string.week))) {
            repeat_group.setVisibility(View.GONE);

        } else if (modeType.equalsIgnoreCase(activity.getResources().getString(R.string.month))) {
            repeat_group.setVisibility(View.VISIBLE);
            rvWeekday_list.setVisibility(View.GONE);

        } else if (modeType.equalsIgnoreCase(activity.getResources().getString(R.string.yes))) {
            update_repeat_group.setVisibility(View.VISIBLE);

        } else if (modeType.equalsIgnoreCase(activity.getResources().getString(R.string.no))) {
            update_repeat_group.setVisibility(View.GONE);

        }
    }
}
