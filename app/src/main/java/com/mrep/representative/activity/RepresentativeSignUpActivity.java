package com.mrep.representative.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;
import com.mrep.activity.RepresentativeBaseActivity;

public class RepresentativeSignUpActivity extends RepresentativeBaseActivity implements View.OnClickListener {
    private Activity activity;
    private Toolbar toolbar;
    private AppCompatTextView mTitle;
    private MaterialButton btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.representative_activity_sign_up);
        onFindViews();
        onClickListener();
        onSetToolbar();
    }

    private void onClickListener() {
        btn_signUp.setOnClickListener(this);
    }

    private void onFindViews() {
        activity = RepresentativeSignUpActivity.this;
        mTitle = findViewById(R.id.mTitle);
        toolbar = findViewById(R.id.toolbar);
        btn_signUp = findViewById(R.id.btn_signUp);
    }

    private void onSetToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
        mTitle.setText("");
        getSupportActionBar().setTitle(activity.getResources().getString(R.string.profile_registration));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signUp:
                onSignUp();
                break;
            default:
                break;
        }
    }

    private void onSignUp() {
        startActivity(new Intent(activity, RepresentativePopupActivity.class));
    }


    @Override
    public void onFragmentInteractions(int viewType, String mTitle) {
        super.onFragmentInteractions(viewType, mTitle);

    }
}