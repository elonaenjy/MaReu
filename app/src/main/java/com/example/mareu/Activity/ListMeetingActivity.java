package com.example.mareu.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.Model.Room;
import com.example.mareu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListMeetingActivity extends AppCompatActivity {
    private Menu menu;
    private MyAdapter adapter;
    private MyViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        MyViewModel model = new ViewModelProvider( this ).get( MyViewModel.class );
        setContentView( R.layout.activity_list_meeting );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        setUpRecyclerView();

        createNewMeetingAction();
    }

    //  ****************************************** INIT  *******************************************
    private void setUpRecyclerView() {
        final RecyclerView rv = findViewById( R.id.list_recycler_view );
        rv.setLayoutManager( new LinearLayoutManager( this ) );
        adapter = new MyAdapter();
        rv.setAdapter( adapter );
        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        adapter.setData( (List<Meeting>) model.getMeeting() );

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