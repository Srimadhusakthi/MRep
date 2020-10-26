package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class InviteAdapter extends RecyclerView.Adapter<InviteAdapter.InviteViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public InviteAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public InviteAdapter.InviteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.invite_card, parent, false);
        return new InviteAdapter.InviteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InviteAdapter.InviteViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 14;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {

        public InviteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

