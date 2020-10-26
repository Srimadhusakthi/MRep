package com.mrep.doctor.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mrep.R;
import com.mrep.doctor.adapter.HomeCardAdapter;
import com.mrep.doctor.fragment.DoctorBaseFragment;
import com.mrep.doctor.fragment.home.allinvities.AllInvitiesFragment;
import com.mrep.doctor.fragment.home.approved.ApprovedFragment;
import com.mrep.doctor.fragment.home.blocked.BlockedFragment;
import com.mrep.doctor.fragment.home.pending.PendingFragment;
import com.mrep.doctor.fragment.home.rejected.RejectedFragment;

public class HomeFragment extends DoctorBaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private HomeCardAdapter homeCardAdapter;
    private BottomNavigationView home_tab;
    private RecyclerView status_card_list;
    private View view = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctor_home, container, false);
        onFindView();
        onCardAdapter();
        return view;
    }

    private void onFindView() {
        home_tab = view.findViewById(R.id.home_tab);
        home_tab.setOnNavigationItemSelectedListener(this);
        onLoadFragment(new AllInvitiesFragment());
        status_card_list = view.findViewById(R.id.status_card_list);
        status_card_list.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }


    private void onCardAdapter() {
        homeCardAdapter = new HomeCardAdapter(getActivity());
        status_card_list.setAdapter(homeCardAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(1, activity.getResources().getString(R.string.home));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(1, activity.getResources().getString(R.string.home));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_doctor_allinvites:
                fragment = new AllInvitiesFragment();
                break;
            case R.id.nav_doctor_approved:
                fragment = new ApprovedFragment();
                break;
            case R.id.nav_doctor_pending:
                fragment = new PendingFragment();
                break;
            case R.id.nav_doctor_rejected:
                fragment = new RejectedFragment();
                break;
            case R.id.nav_doctor_blocked:
                fragment = new BlockedFragment();
                break;
        }
        return onLoadFragment(fragment);
    }
}