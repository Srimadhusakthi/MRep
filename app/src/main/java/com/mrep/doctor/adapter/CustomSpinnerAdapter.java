package com.mrep.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.doctor.model.CallPlannerWeekModel;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter<CallPlannerWeekModel> {

    public CustomSpinnerAdapter(Context context,
                                ArrayList<CallPlannerWeekModel> algorithmList) {
        super(context, 0, algorithmList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent) {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_text, parent, false);
        }

        MaterialTextView textViewName = convertView.findViewById(R.id.repeat_option);
        CallPlannerWeekModel currentItem = getItem(position);

        // It is used the name to the TextView when the
        // current item is not null.
        if (currentItem != null) {
            textViewName.setText(currentItem.getmTitle());
        }
        return convertView;
    }
}