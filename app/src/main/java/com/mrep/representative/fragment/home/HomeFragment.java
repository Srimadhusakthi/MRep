package com.mrep.representative.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.doctor.adapter.HomeCardAdapter;
import com.mrep.doctor.fragment.home.HomeViewModel;
import com.mrep.representative.adapter.UpcomingMeetingAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class HomeFragment extends RepresentativeBaseFragment {

    private HomeViewModel homeViewModel;
    private HomeCardAdapter homeCardAdapter;
    private UpcomingMeetingAdapter upcomingMeetingAdapter;
    private RecyclerView status_card_list,upcoming_meeting_list;
    private View view = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_representative_home, container, false);
        onFindView();
        return view;
    }

    private void onFindView() {
        status_card_list = view.findViewById(R.id.status_card_list);
        status_card_list.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        onCardAdapter();

        upcoming_meeting_list = view.findViewById(R.id.upcoming_meeting_list);
        upcoming_meeting_list.setLayoutManager(new LinearLayoutManager(activity));
        onUpcomingMeetingAdapter();
    }


    private void onCardAdapter() {
        homeCardAdapter = new HomeCardAdapter(getActivity());
        status_card_list.setAdapter(homeCardAdapter);
    }
    private void onUpcomingMeetingAdapter() {
        upcomingMeetingAdapter = new UpcomingMeetingAdapter(getActivity());
        upcoming_meeting_list.setAdapter(upcomingMeetingAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity.onFragmentInteractions(1, activity.getResources().getString(R.string.home));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden)
            activity.onFragmentInteractions(1, activity.getResources().getString(R.string.home));
    }
}