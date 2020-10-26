package com.mrep.doctor.fragment.home.rejected;

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
import com.mrep.doctor.adapter.RejectedAdapter;

public class RejectedFragment extends Fragment {

    private RecyclerView rejected_list;
    private View view = null;
    private RejectedAdapter rejectedAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_rejected, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        rejected_list = view.findViewById(R.id.invite_list);
        rejected_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        onRejectedAdapter();
    }

    private void onRejectedAdapter() {
        rejectedAdapter = new RejectedAdapter(getActivity());
        rejected_list.setAdapter(rejectedAdapter);

    }


}

