package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;

import java.util.ArrayList;

public class BlockedAdapter extends RecyclerView.Adapter<BlockedAdapter.InviteViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public BlockedAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public BlockedAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.invite_card, parent, false);
        return new BlockedAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlockedAdapter.InviteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView user_name, company_name, current_status;
        private LinearLayout status_layout;

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

