package com.mrep.doctor.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.doctor.fragment.DoctorBaseFragment;

public class ProfileFragment extends DoctorBaseFragment implements View.OnClickListener {

    private ProfileViewModel slideshowViewModel;
    private MaterialTextView mEdit, change_password;
    private View view = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        view = inflater.inflate(R.layout.fragment_doctor_profile, container, false);
        onFindView();
        onClickListener();

        return view;
    }

    private void onClickListener() {
        mEdit.setOnClickListener(this);
        change_password.setOnClickListener(this);
    }

    private void onFindView() {
        mEdit = view.findViewById(R.id.edit);
        change_password = view.findViewById(R.id.change_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_password:
                activity.navController.navigate(R.id.action_profile_to_change_password);
                break;
            case R.id.edit:
                activity.navController.navigate(R.id.action_profile_to_edit);
                break;
        }

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
}
