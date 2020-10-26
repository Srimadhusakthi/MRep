package com.mrep.representative.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mrep.R;
import com.mrep.doctor.model.CallPlannerWeekModel;
import com.mrep.representative.activity.RepresentativeActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RepresentativeBaseFragment extends Fragment {

    public RepresentativeActivity activity;
    protected onFragmentInteractions listener;
    private onSelectedDate onSelectedDate;
    private int mYear, mMonth, mDay;
    private String mSelectedDate = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (RepresentativeActivity) context;
        listener = (onFragmentInteractions) context;
        onSelectedDate = (onSelectedDate) context;
    }


    @Override
    public void onAttach(@NonNull Activity mActivity) {
        super.onAttach(activity);
        activity = (RepresentativeActivity) mActivity;
        listener = (onFragmentInteractions) activity;
        onSelectedDate = (onSelectedDate) activity;
    }

    public interface onFragmentInteractions {
        void onFragmentInteractions(int viewType, String mTitle);
    }


    public void onDatePickerDialog(Activity activity) {

        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                mSelectedDate = date + "-" + month + 1 + "-" + year;
                selectedDate(mSelectedDate);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    private String selectedDate(String mSelectedDate) {
        this.mSelectedDate = mSelectedDate;
        return mSelectedDate;
    }

    public interface onSelectedDate {
        void selectedMeetingDate(String s);
    }

    public ArrayList<CallPlannerWeekModel> weeklyList() {
        ArrayList<CallPlannerWeekModel> weekList = new ArrayList<>();
        weekList.add(new CallPlannerWeekModel("S", "Sunday"));
        weekList.add(new CallPlannerWeekModel("M", "Monday"));
        weekList.add(new CallPlannerWeekModel("T", "Tuesday"));
        weekList.add(new CallPlannerWeekModel("W", "Wednesday"));
        weekList.add(new CallPlannerWeekModel("T", "Thursday"));
        weekList.add(new CallPlannerWeekModel("F", "Friday"));
        weekList.add(new CallPlannerWeekModel("S", "Saturday"));
        return weekList;
    }

    public String parseDate(String inputDate, SimpleDateFormat inputDateFormat, SimpleDateFormat outputDateFormat) {
        Date date = null;
        String outputDateString = null;
        try {
            date = inputDateFormat.parse(inputDate);
            outputDateString = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateString;
    }

    public String getCurrentDate() {
        String mDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd", Locale.getDefault());
        return parseDate(mDate, inputDateFormat, outputDateFormat);
    }

    public String getPresentDay() {
        String mDay = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        return mDay;
    }


    public boolean onLoadFragment(Fragment fragment) {
        if (fragment != null) {
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }
}
