package com.mrep.representative.adapter.doctorlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.mrep.R;

import java.util.ArrayList;

public class BlockedDoctorAdapter extends RecyclerView.Adapter<BlockedDoctorAdapter.BlockedViewHolder> {

    private Activity context;
    private int mSelectedPosition = -1;
    private PendingDoctorAdapter.onItemClickListener itemClickListener;

    public BlockedDoctorAdapter(Activity context) {
        this.context = context;
    }

    public void onAddItemClickListener(PendingDoctorAdapter.onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public BlockedDoctorAdapter.BlockedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_doctorlist_main_item, parent, false);
        return new BlockedDoctorAdapter.BlockedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockedDoctorAdapter.BlockedViewHolder holder, int position) {
        holder.doctor_detail_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedPosition = position;
                notifyDataSetChanged();
            }
        });

        if (mSelectedPosition == position) {
            holder.mDoctor_status_layout.setVisibility(View.VISIBLE);
            holder.mInviteLayout.setVisibility(View.GONE);
        } else {
            holder.mDoctor_status_layout.setVisibility(View.GONE);
            holder.mInviteLayout.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return 14;
    }

    public class BlockedViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mInviteLayout, mAvailabilityLayout, mDoctor_status_layout;
        private MaterialButton btn_edit_info, btn_send_invite, btn_availability;
        private RelativeLayout doctor_detail_layout;

        public BlockedViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor_detail_layout = itemView.findViewById(R.id.doctor_detail_layout);
            mInviteLayout = itemView.findViewById(R.id.invite_layout);
            mAvailabilityLayout = itemView.findViewById(R.id.availability_layout);
            mDoctor_status_layout = itemView.findViewById(R.id.doctor_status_layout);
            mAvailabilityLayout.setVisibility(View.GONE);
            mInviteLayout.setVisibility(View.GONE);
            btn_edit_info = itemView.findViewById(R.id.btn_edit_info);
            btn_send_invite = itemView.findViewById(R.id.btn_send_invite);
            btn_availability = itemView.findViewById(R.id.btn_availability);
        }
    }

    public interface onItemClickListener {

    }
}

