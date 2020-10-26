package com.mrep.representative.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class MyInformationFragment extends RepresentativeBaseFragment implements View.OnClickListener {

    private View view = null;
    private MaterialButton btn_cancel, btn_update;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_representative_edit_manager_info_profile, container, false);
        onFindView();
        onClickListener();

        return view;
    }

    private void onClickListener() {
        btn_update.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    private void onFindView() {
        btn_cancel = view.findViewById(R.id.btn_cancel);
        btn_update = view.findViewById(R.id.btn_update);
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

