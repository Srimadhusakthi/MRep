package com.mrep.representative.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class AccountSettingInformation extends RepresentativeBaseFragment implements View.OnClickListener {

    private View view = null;
    private MaterialButton btn_change_password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_representative_profile_account_setting, container, false);
        onFindView();
        onClickListener();

        return view;
    }

    private void onClickListener() {
        btn_change_password.setOnClickListener(this);
    }

    private void onFindView() {
        btn_change_password = view.findViewById(R.id.btn_change_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change_password:
                activity.navController.navigate(R.id.action_nav_profile_to_change_password);
                break;
        }

    }

}

