package com.mrep.representative.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.button.MaterialButton;
import com.mrep.R;

public class RepresentativePopupActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialButton btn_login, btn_submit_otp;
    private AppCompatImageButton btn_cancel_verification;
    private Activity activity;
    private Toolbar toolbar;
    private LinearLayout otp_verification_layout;
    private NestedScrollView welcome_screen_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.representative_activity_login_verfication);
        onFindViews();
        onClickListener();
        onSetToolbar();
    }

    private void onFindViews() {
        activity = RepresentativePopupActivity.this;
        btn_login = findViewById(R.id.btn_login);
        btn_submit_otp = findViewById(R.id.btn_submit_otp);
        btn_cancel_verification = findViewById(R.id.btn_cancel_verification);
        toolbar = findViewById(R.id.toolbar);
        otp_verification_layout = findViewById(R.id.otp_verification_layout);
        welcome_screen_layout = findViewById(R.id.welcome_screen_layout);
    }

    private void onClickListener() {
        btn_login.setOnClickListener(this);
        btn_submit_otp.setOnClickListener(this);
        btn_cancel_verification.setOnClickListener(this);

    }


    private void onSetToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setTitle(activity.getResources().getString(R.string.otp));
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
            case R.id.btn_login:
                onLogin();
                break;
            case R.id.btn_submit_otp:
                onSubmitOtp();
                break;
            case R.id.btn_cancel_verification:
                activity.finish();
                break;
            default:
                break;
        }
    }


    private void onLogin() {
        startActivity(new Intent(activity, RepresentativeActivity.class));
    }

    private void onSubmitOtp() {
        otp_verification_layout.setVisibility(View.GONE);
        welcome_screen_layout.setVisibility(View.VISIBLE);
        getSupportActionBar().setTitle(activity.getResources().getString(R.string.welcome));
    }
}