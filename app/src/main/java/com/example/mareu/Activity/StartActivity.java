package com.example.mareu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mareu.Model.Meeting;
import com.example.mareu.R;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    public List<Meeting> lMeetings = new ArrayList<Meeting>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start );
        final Intent meetingMainActivity = new Intent().setClass(this, ListMeetingActivity.class);

        ImageView imageView = findViewById(R.id.image_startscreen);
        // Create the animation.

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                lMeetings =  Meeting.generateMeetings();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                 startActivity( meetingMainActivity  );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(anim);
    }
}
