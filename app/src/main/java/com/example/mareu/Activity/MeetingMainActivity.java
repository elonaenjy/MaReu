package com.example.mareu.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.Service.MeetingApiService;
import com.example.mareu.di.DI;
import com.google.android.material.appbar.AppBarLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MeetingMainActivity extends AppCompatActivity {
    private Menu menu;
    private MyAdapter adapter;
    private MeetingApiService apiService;

    public void setup() {
        apiService = DI.getNewInstanceApiService();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_meeting );

        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        setUpRecyclerView();
    }

    //  ****************************************** INIT  *******************************************
    private void setUpRecyclerView() {
        final RecyclerView rv = findViewById(R.id.list_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter();
        rv.setAdapter(adapter);

        apiService = DI.getMeetingApiService();
        adapter.setData(apiService.getMeetings());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_filtre, menu);
        showOption(R.id.filtre_list);
        return true;
    }
    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }

    }

