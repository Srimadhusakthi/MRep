package com.mrep.representative.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class NotificationRepresentativeAdapter extends RecyclerView.Adapter<NotificationRepresentativeAdapter.NotificationViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public NotificationRepresentativeAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public NotificationRepresentativeAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_notification_representative_item, parent, false);
        return new NotificationRepresentativeAdapter.NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationRepresentativeAdapter.NotificationViewHolder holder, int position) {


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

