package com.mrep.representative.fragment.doctorlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mrep.R;
import com.mrep.representative.activity.RepresentativeActivity;
import com.mrep.representative.fragment.RepresentativeBaseFragment;
import com.mrep.representative.fragment.doctorlist.approved.ApprovedFragment;
import com.mrep.representative.fragment.doctorlist.blocked.BlockedFragment;
import com.mrep.representative.fragment.doctorlist.newdoctorlist.NewDoctorFragment;
import com.mrep.representative.fragment.doctorlist.pending.PendingFragment;

public class DoctorListFragment extends RepresentativeBaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView nav_doctor_list_tab;
    private View view = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctorlist, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        nav_doctor_list_tab = view.findViewById(R.id.nav_doctor_list_tab);
        nav_doctor_list_tab.setOnNavigationItemSelectedListener(this);
        onLoadFragment(new NewDoctorFragment());
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(2, activity.getResources().getString(R.string.doctor_list));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(2, activity.getResources().getString(R.string.doctor_list));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_doctor_list:
                fragment =new NewDoctorFragment();
                break;
            case R.id.nav_pending:
                fragment =new PendingFragment();
                break;
            case R.id.nav_approved:
                fragment =new ApprovedFragment();
                break;
            case R.id.nav_blocked:
                fragment =new BlockedFragment();
                break;
        }
        return onLoadFragment(fragment);
    }
}