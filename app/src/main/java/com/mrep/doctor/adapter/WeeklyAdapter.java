package com.mrep.doctor.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.doctor.model.CallPlannerWeekModel;

import java.util.ArrayList;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.WeeklyViewHolder> {

    private Activity context;
    private ArrayList<CallPlannerWeekModel> weekList;
    int mSelectedItem = -1;
    private onSelectedDayListener listener;

    public WeeklyAdapter(Activity context, ArrayList<CallPlannerWeekModel> weekList) {
        this.context = context;
        this.weekList = weekList;
//        this.listener = (onSelectedDayListener) context;
    }

    public void setCallBack(onSelectedDayListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public WeeklyAdapter.WeeklyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_day_name, parent, false);
        return new WeeklyAdapter.WeeklyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyAdapter.WeeklyViewHolder holder, int position) {
        CallPlannerWeekModel plannerWeekModel = weekList.get(position);
        holder.dayName.setText(plannerWeekModel.getmTitle());
        holder.dayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedItem = position;
                listener.onSelectedDay(plannerWeekModel.getmSubTitle());
                holder.dayName.setBackground(context.getResources().getDrawable(R.drawable.rounded_selected));
                notifyDataSetChanged();
            }
        });

        if (mSelectedItem == position) {
            holder.dayName.setBackground(context.getResources().getDrawable(R.drawable.rounded_selected));
        } else {
            holder.dayName.setBackground(context.getResources().getDrawable(R.drawable.rounded));
        }
    }

    @Override
    public int getItemCount() {
        return weekList.size();
    }

    public class WeeklyViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView dayName;

        public WeeklyViewHolder(@NonNull View itemView) {
            super(itemView);
            dayName = itemView.findViewById(R.id.dayName);
        }
    }


    public interface onSelectedDayListener {
        void onSelectedDay(String mDay);
    }
}

