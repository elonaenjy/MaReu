package com.example.mareu.Activity;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.Model.Room;
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
    public List<Room> lRoomMeeting = Room.generateRooms();
    public boolean[] KEEP_FILTER_ROOM;    // Keeps memory of the room filter selection

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

            case R.id.menu_filter_date: {
                setDateFilter();
                return true;
            }

            case R.id.menu_filter_room: {
                setRoomsFilter();
                return true;
            }

            default:
                return super.onOptionsItemSelected( item );
        }
    }

    public List<Meeting> setDateSorter() {
        final List<Meeting> lMeetingsSort = listMeetings;
        Collections.sort(lMeetingsSort, (o1, o2) -> {
            if (o1.getMeetingStartDate() == null || o2.getMeetingStartDate() == null)
                return 0;
            return o1.getMeetingStartDate().compareTo(o2.getMeetingStartDate());
        });
        return lMeetingsSort;
    }

    private void setDateFilter() {
        Calendar mCalendarPicker = Calendar.getInstance();
        // Build an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final DatePicker datePicker = new DatePicker(this);
        datePicker.setCalendarViewShown(false);

        builder.setView(datePicker);

        builder.setPositiveButton(R.string.filter_ok_text, (dialog, id) -> {
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();
            mCalendarPicker.set(year, month, day);
            adapter.setData(filterMeetingsByDate(mCalendarPicker));
        });
        builder.setNeutralButton(R.string.filter_reset_text, (dialog, id) -> {
            adapter.setData(listMeetings);
        });
        builder.show();
    }

    public List<Meeting> filterMeetingsByDate(Calendar datePicked) {
        final List<Meeting> meetings = listMeetings;
        List<Meeting> lMeetingsFiltered = new ArrayList<>();
        int size = meetings.size();
        for (int e = 0; e < size; e++) {
            Calendar mMeetingsCalendar = Calendar.getInstance();
            mMeetingsCalendar.setTime(meetings.get(e).getMeetingStartDate());
            if (datePicked.get(Calendar.YEAR) == mMeetingsCalendar.get(Calendar.YEAR)
                    && datePicked.get(Calendar.DAY_OF_YEAR) == mMeetingsCalendar.get(Calendar.DAY_OF_YEAR)) {
                lMeetingsFiltered.add(meetings.get(e));
            }
        }
        return lMeetingsFiltered;
    }


    public void setRoomsFilter() {
        // Build an AlertDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // String array for alert dialog multi choice items
        final int numberRooms = lRoomMeeting.size();
        String[] mRooms = getRoomsAsStringList();
        // Boolean array for initial selected items
        final boolean[] checkedRooms = new boolean[numberRooms];
        // Keep memory of the filter selection
        if (KEEP_FILTER_ROOM != null) {
            System.arraycopy(KEEP_FILTER_ROOM, 0, checkedRooms, 0, numberRooms);
        }

        // Set multiple choice items for alert dialog
        builder.setMultiChoiceItems(mRooms, checkedRooms, (dialog, which, isChecked) -> {
            // Update the current focused item's checked status
            checkedRooms[which] = isChecked;
        });

        // Specify the dialog is not cancelable
        builder.setCancelable(false);

        // Set a title for alert dialog
        builder.setTitle(R.string.filter_rooms_text);

        // Set the positive/yes button click listener
        builder.setPositiveButton(R.string.filter_ok_text, (dialog, which) -> {
        });

        // Set the negative/no button click listener
        builder.setNeutralButton(R.string.filter_reset_text, (dialog, which) -> {
            adapter.setData(listMeetings);
            KEEP_FILTER_ROOM = null;
        });

        final AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.setOnShowListener(dialogInterface -> {

            Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            button.setOnClickListener(view -> {
                // Checks the checked rooms
                boolean atLeastOneChecked = false;
                for (boolean checked : checkedRooms) {
                    if (checked) {
                        atLeastOneChecked = true;
                        break;
                    }
                }

                // if no rooms checked, Toast to alert user
                if (!atLeastOneChecked) {
                    Toast toastRoomNotSelected = Toast.makeText(getApplicationContext(), R.string.toast_room_not_selected, Toast.LENGTH_SHORT);
                    toastRoomNotSelected.setGravity( Gravity.CENTER, 0, 0);
                    View toastViewCreateMeeting = toastRoomNotSelected.getView();
                    TextView toastTextCreateMeeting = toastViewCreateMeeting.findViewById(android.R.id.message);
                    toastTextCreateMeeting.setTextColor( ContextCompat.getColor(getApplicationContext(), R.color.toast_add_meeting_color));
                    toastRoomNotSelected.show();
                } else {
                    List<Meeting> mMeetingsFiltered = filterMeetingsByRoom(checkedRooms);
                    dialog.dismiss();
                    adapter.setData(mMeetingsFiltered);
                    KEEP_FILTER_ROOM = checkedRooms;
                }

            });
        });
        dialog.show();

    }




    public String[] getRoomsAsStringList() {
        int numberRooms;
        numberRooms = lRoomMeeting.size();
        String[] lRooms = new String[numberRooms];
        for (int i = 0; i < numberRooms; i++) {
            lRooms[i] = lRoomMeeting.get(i).getRoomName();
        }
        return lRooms;
    }

    public List<Meeting> filterMeetingsByRoom(boolean[] checkedRooms) {

        List<Meeting> mMeetingsFiltered = new ArrayList<>();
        String[] mRooms = getRoomsAsStringList();
        // Convert the Rooms array to list
        final List<String> mRoomsList = Arrays.asList(mRooms);
        int sizeMeetingsList = listMeetings.size();

        for (int i = 0; i < checkedRooms.length; i++) {
            boolean checked = checkedRooms[i];
            if (checked) {
                String mRoomFiltered = mRoomsList.get(i);
                for (int e = 0; e < sizeMeetingsList; e++) {


                    if (mRoomFiltered.equals(listMeetings.get(e).getIdRoom())) {
                        mMeetingsFiltered.add(listMeetings.get(e));
                    }
                }
            }
        }
        return mMeetingsFiltered;
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