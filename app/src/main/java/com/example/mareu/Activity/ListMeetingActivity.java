package com.example.mareu.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListMeetingActivity<listMeetings> extends AppCompatActivity {

    private Menu menu;
    private MyViewModel viewModel;
    private List<Meeting> listMeetings;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
//        viewModel = new ViewModelProvider( this ).get(MyViewModel.class);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MyViewModel.class);
        setContentView( R.layout.activity_list_meeting );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        setUpRecyclerView();

        createNewMeetingAction();

    }

    //  ****************************************** INIT  *******************************************
    private void setUpRecyclerView() {
        final MyAdapter adapter = new MyAdapter();
        RecyclerView recyclerView = findViewById(R.id.list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted(state);
                recyclerView.smoothScrollToPosition(Integer.MAX_VALUE);
            }
        });
        recyclerView.setAdapter(adapter);

      viewModel.getMeeting().observe(this,  new Observer<List<Meeting>>() {
          @Override
          public void onChanged(@Nullable List<Meeting> meetingsList) {
                        listMeetings = meetingsList;
                    }

      });
         // We "wire" the LiveData : we observe it and any time the database changes, it will change
        // the LiveData, and the observer will be triggered, calling "onChanged". This is at this
        // moment that we tell the adapter to change its data with the special method "submitList"

        listMeetings = viewModel.getMeeting().getValue();

        adapter.setData( listMeetings );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate( R.menu.menu_filtre, menu );
        showOption( R.id.filtre_list );
        return true;
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem( id );
        item.setVisible( true );
    }

    //  ****************************************** ACTIONS  ****************************************

    private void createNewMeetingAction() {
        FloatingActionButton mButtonNewMeeting = findViewById( R.id.button_add_meeting );
        mButtonNewMeeting.setOnClickListener( v -> {
            Intent intent = new Intent(ListMeetingActivity.this, AddMeetingActivity.class);
            startActivity(intent);
        } );
    }
}