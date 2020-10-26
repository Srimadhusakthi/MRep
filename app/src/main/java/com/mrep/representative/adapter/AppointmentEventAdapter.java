package com.mrep.representative.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.mrep.R;
import com.mrep.representative.activity.RepresentativeActivity;

import java.util.ArrayList;

public class AppointmentEventAdapter extends RecyclerView.Adapter<AppointmentEventAdapter.InviteViewHolder> {

    private RepresentativeActivity activity;
    private ArrayList<String> mList;

    public AppointmentEventAdapter(RepresentativeActivity context) {
        this.activity = context;
    }


    @NonNull
    @Override
    public AppointmentEventAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_callplanner_agenda_view, parent, false);
        return new AppointmentEventAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentEventAdapter.InviteViewHolder holder, int position) {

        AppointmentSubEventAdapter subEventAdapter = new AppointmentSubEventAdapter(activity);
        holder.mSubEventList.setAdapter(subEventAdapter);
        holder.mAgendaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.navController.navigate(R.id.action_nav_appointment_to_appointment_info);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class InviteViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mSubEventList;
        private MaterialCardView mAgendaCard;


        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);
            mAgendaCard = itemView.findViewById(R.id.agenda_card);
            mSubEventList = itemView.findViewById(R.id.sub_event_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            mSubEventList.setLayoutManager(linearLayoutManager);


        }
    }
}

