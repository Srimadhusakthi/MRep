package com.mrep.representative.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class AppointmentSubEventAdapter extends RecyclerView.Adapter<AppointmentSubEventAdapter.InviteViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public AppointmentSubEventAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public AppointmentSubEventAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_appointment_agenda_list, parent, false);
        return new AppointmentSubEventAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentSubEventAdapter.InviteViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mSubEventList;

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

