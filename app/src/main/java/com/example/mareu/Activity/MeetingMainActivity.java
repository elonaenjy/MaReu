package com.example.mareu.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mareu.R;
import com.example.mareu.Service.MeetingApiService;
import com.example.mareu.di.DI;
import com.google.android.material.appbar.AppBarLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MeetingMainActivity extends AppCompatActivity {
    private Menu menu;

    // UI Components
    private String dateReunion;
    private MeetingApiService service;
    public void setup() {
        service = DI.getNewInstanceApiService();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_meeting );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

//        switch (item.getItemId()) {
//            case android.R.id.home: {
//                finish();
//                return true;
//            }
//            case R.id.favorit_zoom : {
//                if (!isFavorite) {
//                    item.setIcon( R.drawable.ic_baseline_star_24 );
//                    addFavorit( neighbour );
//                } else {
//                    item.setIcon( R.drawable.ic_baseline_star_border_24 );
//                    deleteFavorit( neighbour );
//                 }
        return true;
    }


//        return super.onOptionsItemSelected( item );
    }

