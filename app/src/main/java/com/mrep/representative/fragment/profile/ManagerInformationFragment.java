package com.mrep.representative.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class ManagerInformationFragment extends RepresentativeBaseFragment implements View.OnClickListener {

    private View view = null;
    private MaterialButton btn_edit_info;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_representative_profile_manger_information, container, false);
        onFindView();
        onClickListener();

        return view;
    }

    private void onClickListener() {
        btn_edit_info.setOnClickListener(this);
    }

    private void onFindView() {
        btn_edit_info = view.findViewById(R.id.btn_edit_info);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_edit_info:
                activity.navController.navigate(R.id.action_nav_profile_to_edi_manager_informarmationprofile);
                break;
        }

    }

}

