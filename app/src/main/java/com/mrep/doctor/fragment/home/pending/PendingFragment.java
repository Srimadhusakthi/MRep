package com.mrep.doctor.fragment.home.pending;

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
import com.mrep.doctor.adapter.PendingAdapter;

public class PendingFragment extends Fragment {

    private RecyclerView pending_list;
    private View view = null;
    private PendingAdapter pendingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_pending, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        pending_list = view.findViewById(R.id.invite_list);
        pending_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        onPendingAdapter();
    }

    private void onPendingAdapter() {
        pendingAdapter = new PendingAdapter(getActivity());
        pending_list.setAdapter(pendingAdapter);

    }


}
