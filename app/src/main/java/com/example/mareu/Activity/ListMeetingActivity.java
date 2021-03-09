package com.example.mareu.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class ListMeetingActivity extends AppCompatActivity {
    private Menu menu;
    public MyViewModel viewModel;
    public List<Meeting> listMeetings;
    public Meeting aMeeting;
    List<Meeting> listMeetingSort = new ArrayList<>();
    private MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Intent intent = getIntent();
        if (intent != null) {
            aMeeting = (Meeting) getIntent().getSerializableExtra( "MEETING" );
        }

        viewModel = new ViewModelProvider( this, ViewModelProvider.AndroidViewModelFactory.getInstance( this.getApplication() ) ).get( MyViewModel.class );
        setContentView( R.layout.activity_list_meeting );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        setUpRecyclerView();

        createNewMeetingAction();

    }

    //  ****************************************** INIT  *******************************************
    private void setUpRecyclerView() {
        MyAdapter adapter = new MyAdapter();
        RecyclerView recyclerView = findViewById( R.id.list_recycler_view );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) {
            @Override
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted( state );
                recyclerView.smoothScrollToPosition( Integer.MAX_VALUE );
                }
            } );

        recyclerView.setAdapter( adapter );

        viewModel.getMeeting().observe( this, new Observer<List<Meeting>>() {
            @Override
            public void onChanged(@Nullable List<Meeting> meetingsList) {
                listMeetings = meetingsList;
                if (aMeeting != null) {
                    listMeetings.add( aMeeting );
                    Log.i( "TAG", "reunion ajoutée : " + aMeeting.getMeetingSubject() );
                    meetingsList = listMeetings;
                }
                adapter.setData( listMeetings );
                adapter.notifyDataSetChanged();
            }
        } );
    }

    //  ****************************************** MENU ********************************************

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate( R.menu.menu_filtre, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_sort_date: {
                List<Meeting> lMeetingSort = setDateSorter();
                adapter.setData( lMeetingSort);
                return true;
            }
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    public List<Meeting> setDateSorter() {
        final List<Meeting> meetingsSort = listMeetings;
        Collections.sort(meetingsSort, (o1, o2) -> {
            if (o1.getMeetingStartDate() == null || o2.getMeetingStartDate() == null)
                return 0;
            return o1.getMeetingStartDate().compareTo(o2.getMeetingStartDate());
        });
        return meetingsSort;
        }

    //  ****************************************** ACTIONS  ****************************************

    private void createNewMeetingAction() {
        FloatingActionButton mButtonNewMeeting = findViewById( R.id.button_add_meeting );
        mButtonNewMeeting.setOnClickListener( v -> {
            Intent intent = new Intent( ListMeetingActivity.this, AddMeetingActivity.class );
            startActivity( intent );
        } );
    }




}