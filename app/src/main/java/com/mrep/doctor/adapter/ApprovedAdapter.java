package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class ApprovedAdapter extends RecyclerView.Adapter<ApprovedAdapter.InviteViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public ApprovedAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ApprovedAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.invite_card, parent, false);
        return new ApprovedAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovedAdapter.InviteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

