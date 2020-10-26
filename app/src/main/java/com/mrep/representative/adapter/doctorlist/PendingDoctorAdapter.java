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

public class PendingDoctorAdapter extends RecyclerView.Adapter<PendingDoctorAdapter.PendingViewHolder> {

    private Activity context;
    private int mSelectedPosition = -1;
    private onItemClickListener itemClickListener;

    public PendingDoctorAdapter(Activity context) {
        this.context = context;
    }

    public void onAddItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public PendingDoctorAdapter.PendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_doctorlist_main_item, parent, false);
        return new PendingDoctorAdapter.PendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingDoctorAdapter.PendingViewHolder holder, int position) {

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

    public class PendingViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mInviteLayout, mAvailabilityLayout, mDoctor_status_layout;
        private MaterialButton btn_edit_info, btn_send_invite, btn_availability;
        private RelativeLayout doctor_detail_layout;

        public PendingViewHolder(@NonNull View itemView) {
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

