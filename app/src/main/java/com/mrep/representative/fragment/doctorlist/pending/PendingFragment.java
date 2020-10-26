package com.mrep.representative.fragment.doctorlist.pending;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.representative.adapter.doctorlist.PendingDoctorAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class PendingFragment extends RepresentativeBaseFragment implements PendingDoctorAdapter.onItemClickListener {

    private View view = null;
    private RecyclerView newDoctorPendingList;
    private PendingDoctorAdapter pendingAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctorlist_pending, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        newDoctorPendingList = view.findViewById(R.id.doctor_pending_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        newDoctorPendingList.setLayoutManager(linearLayoutManager);
        pendingAdapter = new PendingDoctorAdapter(activity);
        pendingAdapter.onAddItemClickListener(this);
        newDoctorPendingList.setAdapter(pendingAdapter);
    }


}
