package com.mrep.representative.fragment.doctorlist.newdoctorlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrep.R;
import com.mrep.doctor.adapter.HomeCardAdapter;
import com.mrep.representative.adapter.doctorlist.NewDoctorAdapter;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewDoctorFragment extends RepresentativeBaseFragment implements NewDoctorAdapter.onItemClickListener {

    private View view = null;
    private RecyclerView newDoctorList;
    private NewDoctorAdapter doctorAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctorlist_new, container, false);


        onFindView();
        return view;
    }

    private void onFindView() {
        newDoctorList = view.findViewById(R.id.new_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        newDoctorList.setLayoutManager(linearLayoutManager);
        doctorAdapter = new NewDoctorAdapter(activity);
        doctorAdapter.onAddItemClickListener(this);
        newDoctorList.setAdapter(doctorAdapter);
    }


}
