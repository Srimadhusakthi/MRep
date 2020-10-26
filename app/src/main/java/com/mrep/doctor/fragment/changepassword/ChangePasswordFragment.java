package com.mrep.doctor.fragment.changepassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.doctor.fragment.DoctorBaseFragment;

public class ChangePasswordFragment extends DoctorBaseFragment implements View.OnClickListener {

    private View view = null;
    private LinearLayout change_password_mobile_layout, change_password_otp_layout, change_password_pwd_layout;
    private MaterialButton btn_proceed, btn_verify, btn_change_password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile_changepassword, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onFindView() {
        change_password_mobile_layout = view.findViewById(R.id.change_password_mobile_layout);
        change_password_otp_layout = view.findViewById(R.id.change_password_otp_layout);
        change_password_pwd_layout = view.findViewById(R.id.change_password_pwd_layout);
        /*button view*/
        btn_proceed = view.findViewById(R.id.btn_proceed);
        btn_verify = view.findViewById(R.id.btn_verify);
        btn_change_password = view.findViewById(R.id.btn_change_password);

        onPasswordNavigationLayout(View.VISIBLE, View.GONE, View.GONE);
    }

    private void onClickListener() {
        btn_proceed.setOnClickListener(this);
        btn_verify.setOnClickListener(this);
        btn_change_password.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(3, activity.getResources().getString(R.string.change_password));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(3, activity.getResources().getString(R.string.change_password));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_proceed:
                onPasswordNavigationLayout(View.GONE, View.VISIBLE, View.GONE);
                break;
            case R.id.btn_verify:
                onPasswordNavigationLayout(View.GONE, View.GONE, View.VISIBLE);
                break;
            case R.id.btn_change_password:
                activity.onSupportNavigateUp();
                break;
            default:
                break;
        }
    }


    private void onPasswordNavigationLayout(int mobile_layout, int otp_layout, int pwd_layout) {
        change_password_mobile_layout.setVisibility(mobile_layout);
        change_password_otp_layout.setVisibility(otp_layout);
        change_password_pwd_layout.setVisibility(pwd_layout);
    }
}