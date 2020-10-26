package com.mrep.representative.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.doctor.fragment.profile.ProfileViewModel;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class ProfileFragment extends RepresentativeBaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private View view = null;
    private BottomNavigationView mProfileNavigationView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_representative_profile, container, false);
        onFindView();
        onClickListener();

        return view;
    }

    private void onClickListener() {
        mProfileNavigationView.setOnNavigationItemSelectedListener(this);
        onLoadFragment(new MyInformationFragment());
    }

    private void onFindView() {
        mProfileNavigationView = view.findViewById(R.id.representative_edit_profile_tab);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(2, activity.getResources().getString(R.string.profile));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(2, activity.getResources().getString(R.string.profile));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_my_information:
                fragment = new MyInformationFragment();
                break;
            case R.id.nav_manager_information:
                fragment = new ManagerInformationFragment();
                break;
            case R.id.nav_account_setting:
                fragment = new AccountSettingInformation();
                break;
        }
        return onLoadFragment(fragment);
    }
}
