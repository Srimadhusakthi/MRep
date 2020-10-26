package com.mrep.representative.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.video.VideoCallActivity;
import com.mrep.video.openvcall.ui.GroupVideoCallActivity;

import java.util.ArrayList;

public class UpcomingMeetingAdapter extends RecyclerView.Adapter<UpcomingMeetingAdapter.InviteViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public UpcomingMeetingAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public UpcomingMeetingAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcoming_meeting_card, parent, false);
        return new UpcomingMeetingAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMeetingAdapter.InviteViewHolder holder, int position) {
        holder.mJoinCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, VideoCallActivity.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return 14;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {
        private MaterialButton mJoinCall;

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);
            mJoinCall = itemView.findViewById(R.id.join_call);
        }
    }
}


