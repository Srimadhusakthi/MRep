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
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.mrep.R;
import com.mrep.representative.activity.RepresentativeActivity;

import java.util.ArrayList;

public class ApprovedDoctorAdapter extends RecyclerView.Adapter<ApprovedDoctorAdapter.DoctorViewHolder> {

    private RepresentativeActivity activity;
    private ArrayList<String> mList;
    private onItemClickListener itemClickListener;
    private int mSelectedPosition = -1;

    public ApprovedDoctorAdapter(RepresentativeActivity context) {
        this.activity = context;
    }

    public void onAddItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public ApprovedDoctorAdapter.DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_doctorlist_main_item, parent, false);
        return new ApprovedDoctorAdapter.DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovedDoctorAdapter.DoctorViewHolder holder, int position) {

        holder.doctor_detail_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedPosition = position;
                notifyDataSetChanged();
            }
        });

        if (mSelectedPosition == position) {
            holder.mDoctor_status_layout.setVisibility(View.VISIBLE);
            holder.mAvailabilityLayout.setVisibility(View.VISIBLE);
        } else {
            holder.mDoctor_status_layout.setVisibility(View.GONE);
        }
        holder.btn_availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.navController.navigate(R.id.action_nav_doctor_list_to_doctor_details);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 14;
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout doctor_detail_layout;
        private LinearLayout mInviteLayout, mAvailabilityLayout, mDoctor_status_layout;
        private MaterialButton btn_edit_info, btn_send_invite, btn_availability;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor_detail_layout = itemView.findViewById(R.id.doctor_detail_layout);
            mInviteLayout = itemView.findViewById(R.id.invite_layout);
            mAvailabilityLayout = itemView.findViewById(R.id.availability_layout);
            mDoctor_status_layout = itemView.findViewById(R.id.doctor_status_layout);
            mInviteLayout.setVisibility(View.GONE);
            btn_edit_info = itemView.findViewById(R.id.btn_edit_info);
            btn_send_invite = itemView.findViewById(R.id.btn_send_invite);
            btn_availability = itemView.findViewById(R.id.btn_availability);

        }
    }

    public interface onItemClickListener {
    }

}

