package com.mrep.representative.fragment.doctorlist.approved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.representative.adapter.doctorlist.ApprovedDoctorAdapter;
import com.mrep.representative.adapter.doctorlist.BlockedDoctorAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class ApprovedFragment extends RepresentativeBaseFragment implements ApprovedDoctorAdapter.onItemClickListener {

    private View view = null;
    private RecyclerView newDoctorApproveList;
    private ApprovedDoctorAdapter doctorAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctorlist_approved, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        newDoctorApproveList = view.findViewById(R.id.doctor_approved_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        newDoctorApproveList.setLayoutManager(linearLayoutManager);
        doctorAdapter = new ApprovedDoctorAdapter(activity);
        doctorAdapter.onAddItemClickListener(this);
        newDoctorApproveList.setAdapter(doctorAdapter);
    }


}