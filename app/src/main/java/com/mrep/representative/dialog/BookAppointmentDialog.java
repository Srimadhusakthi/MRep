package com.mrep.representative.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.mrep.R;

public class BookAppointmentDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    private View view = null;
    private AppCompatImageButton btn_cancel_dialog;
    private MaterialButton btn_book_appointment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_book_appointment, container, false);
        onFindView();
        onClickListener();
        return view;
    }

    private void onClickListener() {
        btn_book_appointment.setOnClickListener(this);
        btn_cancel_dialog.setOnClickListener(this);
    }

    private void onFindView() {
        btn_book_appointment = view.findViewById(R.id.btn_book_appointment);
        btn_cancel_dialog = view.findViewById(R.id.btn_cancel_dialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel_dialog:
            case R.id.btn_book_appointment:
                dismiss();
                break;
            default:
                break;
        }
    }
}
