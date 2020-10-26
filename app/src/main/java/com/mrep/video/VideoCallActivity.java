package com.mrep.video;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mrep.R;
import com.mrep.video.openvcall.ui.GroupVideoCallActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;


public class VideoCallActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton btn_one_to_one, btn_group, btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_call);
        onFindView();
        onViewClickListener();
    }

    private void onViewClickListener() {
        btn_one_to_one.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_group.setOnClickListener(this);
    }

    private void onFindView() {
        btn_one_to_one = findViewById(R.id.btn_one_to_one);
        btn_share = findViewById(R.id.btn_share);
        btn_group = findViewById(R.id.btn_group);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one_to_one:
                startActivity(new Intent(VideoCallActivity.this, OneToOneVideoChatViewActivity.class));
                break;
            case R.id.btn_group:
                startActivity(new Intent(VideoCallActivity.this, GroupVideoCallActivity.class));
                break;
            case R.id.btn_share:
                startActivity(new Intent(VideoCallActivity.this, ScreenShareActivity.class));
                break;
            default:
                break;
        }
    }
}