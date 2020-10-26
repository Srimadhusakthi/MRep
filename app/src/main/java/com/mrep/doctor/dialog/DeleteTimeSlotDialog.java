package com.mrep.doctor.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mrep.R;

public class DeleteTimeSlotDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    private View view = null;
    private AppCompatImageButton btn_cancel_dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_delete_timeslot, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onClickListener() {
        btn_cancel_dialog.setOnClickListener(this);
    }

    private void onFindView() {
        btn_cancel_dialog = view.findViewById(R.id.btn_cancel_dialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel_dialog:
                dismiss();
                break;
            default:
                break;
        }
    }
}
