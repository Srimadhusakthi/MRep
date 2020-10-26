package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class NotificationDoctorAdapter extends RecyclerView.Adapter<NotificationDoctorAdapter.NotificationViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public NotificationDoctorAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public NotificationDoctorAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_notification_doctor_item, parent, false);
        return new NotificationDoctorAdapter.NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationDoctorAdapter.NotificationViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

