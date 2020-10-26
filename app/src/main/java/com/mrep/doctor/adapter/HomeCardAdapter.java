package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;

import java.util.ArrayList;

public class HomeCardAdapter extends RecyclerView.Adapter<HomeCardAdapter.HomeCardViewHolder> {

    private Activity context;
    private ArrayList<String> mList;

    public HomeCardAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public HomeCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_cardview, parent, false);
        return new HomeCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCardViewHolder holder, int position) {

        holder.current_status.setText("Pending");
        holder.status_count.setText("109");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class HomeCardViewHolder extends RecyclerView.ViewHolder {
        private TextView status_count, current_status;

        public HomeCardViewHolder(@NonNull View itemView) {
            super(itemView);
            status_count = itemView.findViewById(R.id.status_count);
            current_status = itemView.findViewById(R.id.current_status);
        }
    }
}
