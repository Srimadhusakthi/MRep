package com.mrep.doctor.fragment.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.doctor.adapter.NotificationDoctorAdapter;
import com.mrep.doctor.fragment.DoctorBaseFragment;
import com.mrep.representative.adapter.doctorlist.PendingDoctorAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class DoctorNotification extends DoctorBaseFragment {

    private View view = null;
    private RecyclerView doctor_notification_list;
    private NotificationDoctorAdapter notificationDoctorAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification_doctor, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        doctor_notification_list = view.findViewById(R.id.doctor_notification_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        doctor_notification_list.setLayoutManager(linearLayoutManager);
        notificationDoctorAdapter = new NotificationDoctorAdapter(activity);
        doctor_notification_list.setAdapter(notificationDoctorAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.notification));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.notification));
    }
}
