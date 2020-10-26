package com.mrep.doctor.fragment.home.blocked;

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
import com.mrep.doctor.adapter.BlockedAdapter;

public class BlockedFragment extends Fragment {

    private RecyclerView block_list;
    private View view = null;
    private BlockedAdapter blockedAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_blocked, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        block_list = view.findViewById(R.id.invite_list);
        block_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        onBlockAdapter();
    }

    private void onBlockAdapter() {
        blockedAdapter = new BlockedAdapter(getActivity());
        block_list.setAdapter(blockedAdapter);

    }


}

