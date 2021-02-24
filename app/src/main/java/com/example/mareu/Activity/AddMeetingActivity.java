package com.example.mareu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Room;
import com.example.mareu.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddMeetingActivity extends AppCompatActivity {

    public static final String EMAILS_LIST_SEPARATOR = ", "; // Separator for listview in UI
    private static final int DURATION_MAX_HOURS = 3; // Max duration for a meeting (in hours)
    private static final int DURATION_STEP_MINUTES = 5; // Duration interval for minutes

    public final List<Guest> mGuests = new ArrayList<>();
    public Spinner sRoom;
    public MultiAutoCompleteTextView guestsEmails;

    private final Calendar datePickerCalendar = Calendar.getInstance();
    private final Calendar timePickerCalendar = Calendar.getInstance();

    private Room mRoomMeeting;
    private Date mStartDate;
    private NumberPicker durationMinutes, durationHours;
    private EditText mSubject;
    private TextView startDatePickerText, startTimePickerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_meeting );
        init();
    }

    /**************************************** INIT  ***************************************/
    // Instanciates the views and variables
    private void init() {
        // ************************************ Toolbar init ***************************************
        Toolbar toolbar = findViewById(R.id.toolbar_add_meeting);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // FOR UI
        // ************************************ Layout bindings ************************************
        mSubject = findViewById(R.id.edit_text_add_meeting_subject);
        startDatePickerText = findViewById(R.id.text_add_meeting_datepicker);
        startTimePickerText = findViewById(R.id.text_add_meeting_timepicker);

    }
}