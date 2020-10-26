package com.mrep.doctor.fragment.appointment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mrep.R;
import com.mrep.doctor.adapter.AppointmentEventAdapter;
import com.mrep.doctor.calendar.EventDecorator;
import com.mrep.doctor.fragment.DoctorBaseFragment;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppointmentFragment extends DoctorBaseFragment implements View.OnClickListener {

    private FloatingActionButton mAdd_event;
    private View view = null;
    private MaterialCalendarView calendarMonthView, calendarWeekView;
    private List<CalendarDay> events = new ArrayList<>();
    private RecyclerView event_list;
    private ArrayAdapter mWeekMonthAdapter;
    private AppCompatSpinner modeType;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_appointment, container, false);

        onFindView();
        onWeekMonthList();
        onClickListener();
        makeJsonObjectRequest();
        return view;
    }


    private void onFindView() {
        modeType = view.findViewById(R.id.modeTypeList);
        calendarMonthView = view.findViewById(R.id.calendar_monthView);
        calendarWeekView = view.findViewById(R.id.calendar_weekView);
        event_list = view.findViewById(R.id.event_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        event_list.setLayoutManager(linearLayoutManager);
        onEventList();
    }

    private void onEventList() {
        AppointmentEventAdapter appointmentEventAdapter = new AppointmentEventAdapter(activity);
        event_list.setAdapter(appointmentEventAdapter);
        event_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onShowToast(activity, "clci");
            }
        });
        event_list.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                activity.navController.navigate(R.id.action_appointment_to_reschedule_event);
                activity.onShowToast(activity, "clci");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    //
    private void onClickListener() {

    }


    private void onWeekMonthList() {
        ArrayList<String> weekList = new ArrayList<>();
        weekList.add(activity.getResources().getString(R.string.week));
        weekList.add(activity.getResources().getString(R.string.month));
        mWeekMonthAdapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_item, weekList);
        mWeekMonthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeType.setAdapter(mWeekMonthAdapter);
        modeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onCustomCalenderView(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void onCustomCalenderView(String mType) {
        if (mType.equalsIgnoreCase(activity.getResources().getString(R.string.week))) {
            calendarWeekView.setVisibility(View.VISIBLE);
            calendarMonthView.setVisibility(View.GONE);
        } else {
            calendarWeekView.setVisibility(View.GONE);
            calendarMonthView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(2, activity.getResources().getString(R.string.appointment));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(2, activity.getResources().getString(R.string.appointment));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.add_event:
//                activity.navController.navigate(R.id.action_appointment_to_add_event);
//                break;
            default:
                break;
        }
    }

    private void makeJsonObjectRequest() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

        // i copied your json to load form assets folder
        // in our case you can get the json from the server
        // or any other location of your choice
        String response = loadJSONFromAsset();
        EventDecorator eventDecorator = null;
        try {
            JSONArray jArray = new JSONArray(response);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String StartDate = jsonObject.getString("StartDate");

                String Color = jsonObject.getString("Color");

                Date date = simpleDateFormat.parse(StartDate);

                Log.d("Date ", "" + date);
                CalendarDay day = CalendarDay.from(date);
                events.add(day);

                if (Color.equalsIgnoreCase("red")) {
                    eventDecorator = new EventDecorator(android.graphics.Color.RED, events);
                } else if (Color.equalsIgnoreCase("green")) {
                    eventDecorator = new EventDecorator(android.graphics.Color.GREEN, events);
                } else {

                    eventDecorator = new EventDecorator(android.graphics.Color.YELLOW, events);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        calendarMonthView.addDecorator(eventDecorator);
        calendarWeekView.addDecorator(eventDecorator);

    }

    private String loadJSONFromAsset() {
        return "[\n" +
                "  {\n" +
                "    \"EventID\": 1011,\n" +
                "    \"Title\": \"May Day\",\n" +
                "    \"Description\": \"Holiday for the International Labour Day\",\n" +
                "    \"StartDate\": \"2020-10-14T10:00:00\",\n" +
                "    \"StartTime\": \"00:00:00\",\n" +
                "    \"EndDate\": \"2020-09-02T00:00:00\",\n" +
                "    \"EndTime\": \"00:00:00\",\n" +
                "    \"IsFullDay\": true,\n" +
                "    \"IsHoliday\": false,\n" +
                "    \"Color\": green,\n" +
                "    \"DateTime\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"EventID\": 1020,\n" +
                "    \"Title\": \"d\",\n" +
                "    \"Description\": \"\",\n" +
                "    \"StartDate\": \"2020-10-15T00:00:00\",\n" +
                "    \"StartTime\": \"05:45:00\",\n" +
                "    \"EndDate\": \"2020-10-28T00:00:00\",\n" +
                "    \"EndTime\": \"05:45:00\",\n" +
                "    \"IsFullDay\": false,\n" +
                "    \"IsHoliday\": false,\n" +
                "    \"Color\": red,\n" +
                "    \"DateTime\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"EventID\": 1019,\n" +
                "    \"Title\": \"Mother's Day\",\n" +
                "    \"Description\": \"Mother's day\",\n" +
                "    \"StartDate\": \"2020-10-16T00:00:00\",\n" +
                "    \"StartTime\": \"10:00:00\",\n" +
                "    \"EndDate\": \"2020-10-26T00:00:00\",\n" +
                "    \"EndTime\": \"18:00:00\",\n" +
                "    \"IsFullDay\": false,\n" +
                "    \"IsHoliday\": false,\n" +
                "    \"Color\": green,\n" +
                "    \"DateTime\": null\n" +
                "  }\n" +
                "]";
    }


    public void onNavigation() {
        activity.navController.navigate(R.id.action_appointment_to_reschedule_event);
    }
}