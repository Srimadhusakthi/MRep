package com.mrep.representative.fragment.doctorlist.blocked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.representative.adapter.doctorlist.BlockedDoctorAdapter;
import com.mrep.representative.adapter.doctorlist.PendingDoctorAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class BlockedFragment extends RepresentativeBaseFragment {

    private View view = null;
    private RecyclerView newDoctorBlockedList;
    private BlockedDoctorAdapter doctorAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctorlist_blocked, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        newDoctorBlockedList = view.findViewById(R.id.doctor_blocked_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        newDoctorBlockedList.setLayoutManager(linearLayoutManager);
        doctorAdapter = new BlockedDoctorAdapter(activity);
        newDoctorBlockedList.setAdapter(doctorAdapter);
    }


}