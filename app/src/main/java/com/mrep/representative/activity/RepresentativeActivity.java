package com.mrep.representative.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;
import com.mrep.R;
import com.mrep.activity.RepresentativeBaseActivity;
import com.mrep.representative.fragment.RepresentativeBaseFragment;

public class RepresentativeActivity extends RepresentativeBaseActivity implements RepresentativeBaseFragment.onFragmentInteractions, RepresentativeBaseFragment.onSelectedDate {
    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigationView;
    private RelativeLayout user_detail_layout, title_layout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public NavController navController;
    private MaterialTextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.representative_activity_dashboard);
        onFindView();
        onClickListener();
        onSetToolbar();

    }

    private void onFindView() {
        toolbar = findViewById(R.id.toolbar);
        user_detail_layout = findViewById(R.id.user_detail_layout);
        title_layout = findViewById(R.id.title_layout);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_doctor_list, R.id.nav_appointment, R.id.nav_profile)
                .setDrawerLayout(drawerLayout)
                .build();
        bottomNavigationView = findViewById(R.id.representative_dashboard_home_tab);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        title = findViewById(R.id.title);
    }

    private void onClickListener() {
    }

    private void onSetToolbar() {
        setSupportActionBar(toolbar);
    }

    private void onNavigationBackButton(boolean homeEnabled, boolean titleEnabled) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(homeEnabled);
            getSupportActionBar().setDisplayShowTitleEnabled(titleEnabled);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notification:
                navController.navigate(R.id.nav_representative_notification);
                return true;
            case R.id.search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onFragmentInteractions(int viewType, String mTitle) {

        switch (viewType) {
            case 1:
                onNavigationBackButton(false, false);
                onToolbarView(View.VISIBLE, View.GONE, mTitle);
                break;
            case 2:
                onNavigationBackButton(false, true);
                onToolbarView(View.GONE, View.GONE, mTitle);
                break;
            case 3:
                onNavigationBackButton(true, false);
                onToolbarView(View.GONE, View.VISIBLE, mTitle);
                break;
        }
    }

    private void onToolbarView(int userDetails, int mTitleLayout, String mTitleName) {
        user_detail_layout.setVisibility(userDetails);
        title_layout.setVisibility(mTitleLayout);
        title.setText(mTitleName);
        toolbar.setTitle(mTitleName);
    }

    @Override
    public void selectedMeetingDate(String s) {
        Log.e("SELECTED DATE", s.toString() + "==");
    }


}