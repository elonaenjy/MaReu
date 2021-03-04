package com.example.mareu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;
import com.example.mareu.R;

import java.util.List;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start );
        MyViewModel model = new ViewModelProvider( this ).get( MyViewModel.class );
        model.getMeeting().observe( this, lMeetings -> {
        } );
        model.getGuest().observe( this, lGuests -> {
        } );
        model.getRoom().observe( this, lRooms -> {
        } );

        ImageView imageView = findViewById( R.id.image_startscreen );
        // Create the animation.

        Animation anim = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.fade_in );
        anim.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent( StartActivity.this, ListMeetingActivity.class );
                startActivity( intent );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        } );
        imageView.startAnimation( anim );
    }
}
