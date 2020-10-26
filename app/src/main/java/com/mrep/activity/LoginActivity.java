package com.mrep.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mrep.R;
import com.mrep.databinding.ActivityLoginBinding;
import com.mrep.doctor.activity.DoctorActivity;
import com.mrep.doctor.viewmodel.LoginViewModel;
import com.mrep.representative.activity.RepresentativeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginActivity activity;
    private MaterialButton btn_signIn;
    private MaterialButton btn_representative, btn_doctor;
    private TextInputEditText email, password;
    private LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        activity = LoginActivity.this;
        initVM();
        findView();
        onClickListener();
    }

    private void initVM() {
    }

    private void findView() {
        btn_signIn = findViewById(R.id.btn_signIn);
        btn_doctor = findViewById(R.id.btn_doctor);
        btn_representative = findViewById(R.id.btn_representative);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    private void onClickListener() {
        btn_signIn.setOnClickListener(this);
        btn_doctor.setOnClickListener(this);
        btn_representative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signIn:
                onLogin();
                break;
            case R.id.btn_doctor:
                onDoctorSignUp();
                break;
            case R.id.btn_representative:
                onRepresentativeSignUp();
                break;
            default:
                break;
        }
    }



    private void onLogin() {
        startActivity(new Intent(activity, RepresentativeActivity.class));
    }


    private void onDoctorSignUp() {
        startActivity(new Intent(activity, DoctorActivity.class));
    }

    private void onRepresentativeSignUp() {
        startActivity(new Intent(activity, RepresentativeActivity.class));
    }
}