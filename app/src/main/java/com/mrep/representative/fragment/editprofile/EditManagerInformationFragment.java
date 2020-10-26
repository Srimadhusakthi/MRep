package com.mrep.representative.fragment.editprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class EditManagerInformationFragment extends RepresentativeBaseFragment implements View.OnClickListener {
    private View view = null;
    private MaterialButton btn_cancel, btn_update;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_representative_edit_profile, container, false);
        onFindView();
        onViewClickListener();
        return view;
    }

    private void onFindView() {
        btn_cancel = view.findViewById(R.id.btn_cancel);
        btn_update = view.findViewById(R.id.btn_update);
    }

    private void onViewClickListener() {
        btn_cancel.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.edit_manager_info));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.edit_manager_info));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
            case R.id.btn_update:
                activity.onSupportNavigateUp();
                break;
        }
    }

}