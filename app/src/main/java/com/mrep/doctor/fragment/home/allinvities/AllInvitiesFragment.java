package com.mrep.doctor.fragment.home.allinvities;

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
import com.mrep.doctor.adapter.InviteAdapter;

public class AllInvitiesFragment extends Fragment {

    private RecyclerView invite_list;
    private View view = null;
    private InviteAdapter inviteAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_all_invities, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        invite_list = view.findViewById(R.id.invite_list);
        invite_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        onInviteAdapter();
    }

    private void onInviteAdapter() {
        inviteAdapter = new InviteAdapter(getActivity());
        invite_list.setAdapter(inviteAdapter);

    }


}
