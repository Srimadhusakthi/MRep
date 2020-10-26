package com.mrep.doctor.fragment.home.approved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.doctor.adapter.ApprovedAdapter;

public class ApprovedFragment extends Fragment {

    private RecyclerView approved_list;
    private View view = null;
    private ApprovedAdapter approvedAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_approved, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        approved_list = view.findViewById(R.id.invite_list);
        approved_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        onApprovedAdapter();
    }

    private void onApprovedAdapter() {
        approvedAdapter = new ApprovedAdapter(getActivity());
        approved_list.setAdapter(approvedAdapter);

    }


}
