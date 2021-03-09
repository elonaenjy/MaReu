package com.example.mareu.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.MyViewModel;
import com.example.mareu.Model.Room;
import com.example.mareu.R;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddMeetingActivity extends AppCompatActivity {
    public static final String EMAILS_LIST_SEPARATOR = ", "; // Separator for listview in UI
    private static final int DURATION_MAX_HOURS = 5; // Max duration for a meeting (in hours)
    private static final int DURATION_STEP_MINUTES = 15; // Duration interval for minutes
    public MyViewModel viewModel;
    private List<Meeting> listMeetings;
    private MutableLiveData<List<Meeting>> lMeetings;

    public List<Guest> listGuests = Guest.generateGuests();
    public List<Room> lRooms = Room.generateRooms();
    public MyAdapter adapter;
    public Spinner sRoom;
    public MultiAutoCompleteTextView guestsEmails;

    private long idRoom = 0;

    private final Calendar datePickerCalendar = Calendar.getInstance();
    private final Calendar timePickerCalendar = Calendar.getInstance();

    private Room mRoom;
    private Date mStartDate;
    private NumberPicker durationMinutes, durationHours;
    private EditText mSubject;
    private TextView startDatePickerText, startTimePickerText;
    private List<Integer> mGuestIdList;
    public int nbRoom = lRooms.size();
    private List<Meeting> lstMeetings;

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
        Toolbar toolbar = findViewById( R.id.toolbar_add_meeting );
        setSupportActionBar( toolbar );
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled( true );

        // ************************************ Layout bindings ************************************
        mSubject = findViewById( R.id.edit_text_add_meeting_subject );
        startDatePickerText = findViewById( R.id.text_add_meeting_datepicker );
        startTimePickerText = findViewById( R.id.text_add_meeting_timepicker );

        durationHours = findViewById( R.id.numberpicker_add_meeting_duration_hours_ );
        durationMinutes = findViewById( R.id.numberpicker_add_meeting_duration_minutes_ );
        sRoom = findViewById(R.id.spinner_add_meeting_room);
        guestsEmails = findViewById(R.id.autocomplete_text_add_meeting_guests);

        // ************************************ Layout Parametrization *****************************
        setStartDatePickerDialog();
        setStartTimePickerDialog();
        durationHours.setMaxValue( DURATION_MAX_HOURS );
        durationHours.setMinValue( 0 );
        setDurationsMinutesValues();
        setDurationsMinutesValues();
        setStartDatePickerDialog();
        setStartTimePickerDialog();
        setRoomSpinnerDialog();
        setGuestsArrayAdapter();
    }

    private void setRoomSpinnerDialog() {
         ArrayList<String> mRoomsList = new ArrayList<>();
         mRoomsList.add(0, getResources().getString(R.string.add_meeting_room));

        for (int mId = 1; mId < nbRoom; mId ++ ) {
            String mRoomName = lRooms.get( mId ).getRoomName();
            mRoomsList.add(mRoomName);
            String[] mRoomsArray = mRoomsList.toArray(new String[0]);
            ArrayAdapter<String> adapterRooms
                        = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mRoomsArray);
            sRoom.setAdapter(adapterRooms);
            }
        }


    // DATEPICKER
    private void setStartDatePickerDialog() {
        final DatePickerDialog.OnDateSetListener startDate = (view, year, monthOfYear, dayOfMonth) -> {
            datePickerCalendar.set( Calendar.YEAR, year );
            datePickerCalendar.set( Calendar.MONTH, monthOfYear );
            datePickerCalendar.set( Calendar.DAY_OF_MONTH, dayOfMonth );
            updateStartDateLabel();
        };
        startDatePickerText.setOnClickListener( v -> new DatePickerDialog( AddMeetingActivity.this, startDate, datePickerCalendar
                .get( Calendar.YEAR ), datePickerCalendar.get( Calendar.MONTH ),
                datePickerCalendar.get( Calendar.DAY_OF_MONTH ) ).show() );
    }

    private void updateStartDateLabel() {
        DateFormat dateFormat = DateFormat.getDateInstance( DateFormat.LONG );
        startDatePickerText.setText( dateFormat.format( datePickerCalendar.getTime() ) );
    }

    // TIMEPICKER
    private void setStartTimePickerDialog() {
        final TimePickerDialog.OnTimeSetListener startTime = (view, hourOfDay, minute) -> {
            timePickerCalendar.set( Calendar.HOUR_OF_DAY, hourOfDay );
            timePickerCalendar.set( Calendar.MINUTE, minute );
            updateStartTimeLabel();
        };
        startTimePickerText.setOnClickListener( v -> new TimePickerDialog( AddMeetingActivity.this, startTime, timePickerCalendar
                .get( Calendar.HOUR ), timePickerCalendar.get( Calendar.MINUTE ),
                true ).show() );
    }

    private void updateStartTimeLabel() {
        DateFormat timeFormat = DateFormat.getTimeInstance(
                DateFormat.SHORT);
        startTimePickerText.setText( timeFormat.format( timePickerCalendar.getTime() ) );
    }

    // DURATION MINUTES
    private void setDurationsMinutesValues() {
        int sizeSteps = 60 / DURATION_STEP_MINUTES;
        String[] mins = new String[sizeSteps];
        for (int i = 0; i < sizeSteps; i++) {
            mins[i] = String.valueOf( DURATION_STEP_MINUTES * i );
        }
        int ml = sizeSteps - 1;
        // Prevent ArrayOutOfBoundExceptions by setting values array to null so its not checked
        durationMinutes.setDisplayedValues( null );
        durationMinutes.setMinValue( 0 );
        durationMinutes.setMaxValue( ml );
        durationMinutes.setDisplayedValues( mins );
    }

    // GUESTS LIST   - Sets the autocompletion for the Guests selection
    private void setGuestsArrayAdapter() {
        // Guest list : listGuests
         ArrayList<String> mGuestsMail = new ArrayList<>();
    //     mGuestsMail.add(0, getResources().getString(R.string.add_meeting_guests));
        int nbGuests = listGuests.size();
        for (int mId = 0; mId < nbGuests; mId ++ ) {
            String mGuestEmail = listGuests.get( mId ).getGuestMail();
            mGuestsMail.add( mGuestEmail );
        }
        String[] guestEmailsList = mGuestsMail.toArray( new String[0] );
        ArrayAdapter<String> adapterGuests
                        = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, guestEmailsList);
        guestsEmails.setAdapter(adapterGuests);
        guestsEmails.setThreshold(1);                                                  // Sets the minimum number of characters, to show suggestions
        guestsEmails.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());     // then separates them with a comma
    }


    /*************************************** SAVE REUNION ***********************************/
    // REUNION CREATION BUTTON - Creates the meeting
    private void createMeeting() {
        String mSubjectString = mSubject.getText().toString();
        mStartDate = getStartMeetingDateTimeFromSelection();


    //------ Meeting End Date alimentation = Meeting Start Date + Meeting duration
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTime(mStartDate);
        mCalendar.add(Calendar.HOUR_OF_DAY, durationHours.getValue());
        mCalendar.add(Calendar.MINUTE, durationMinutes.getValue() * DURATION_STEP_MINUTES);
        Date mEndDate = mCalendar.getTime();

        idRoom = getRoomFromRoomNameSelected();
        List<Integer> lGuestId = getIdGuestFromGuestMailSelected();

        // Avoids meeting creation if the duration is 0h0min *******************************
        if (mSubjectString.isEmpty()) {
                toastCancelCreation( R.string.toast_subject_empty );
        } else if (durationHours.getValue() == 0 && durationMinutes.getValue() == 0) {
                toastCancelCreation( R.string.toast_duration_empty );
                 }
              else if (idRoom == 0) {
                  toastCancelCreation(R.string.toast_room_empty);
                  }
                    else {
                        Meeting mMeeting = new Meeting(
                                System.currentTimeMillis(),
                                idRoom,
                                mSubjectString,
                                mStartDate,
                                mEndDate,
                                lGuestId   );
                        saveMeeting(mMeeting);
        }
    }


    // Gets the Room object from the Room name selected in the Spinner
    private long getRoomFromRoomNameSelected() {
        idRoom = 0;
        for (int mId = 1; mId < nbRoom; mId ++ ) {
            Room meetingRoom = lRooms.get( mId );
            if (meetingRoom.getRoomName().equals( sRoom.getSelectedItem().toString() )) {
                idRoom = meetingRoom.getId();
                mId = nbRoom + 1;
            }
        }
        return idRoom;
    }
    // Gets the GuestList from the mail selected
    private List<Integer> getIdGuestFromGuestMailSelected() {
        List<Integer> lGuestId = new ArrayList<>();
        String[] GuestSelected = guestsEmails.getText().toString().split(EMAILS_LIST_SEPARATOR);
        int nbGuest = listGuests.size() ;
        int nbGuestSelected = GuestSelected.length;
        String email = "";
        String email2 ="";

        for (int ind = 0; ind < nbGuestSelected; ind ++ ) {
            email = GuestSelected[ind];
            for (int ind2 = 0; ind2 < nbGuest; ind2 ++) {
                email2 = listGuests.get(ind2).getGuestMail();
                 System.out.println("email : " + email);
                System.out.println("ref Guest : " + email2);
                if (email.equals( email2 )) {
                    lGuestId.add( listGuests.get(ind2).getId() );
                }
            }
        }
        return lGuestId;
    }

    /**
         * Adds the given task to the list of created tasks.
         *
         * @param mMeeting the meeting to be added to the list
         */
        private void saveMeeting(Meeting mMeeting) {
            Intent intent = new Intent(AddMeetingActivity.this, ListMeetingActivity.class);
            intent.putExtra( "MEETING", mMeeting );
            startActivity(intent);
    }

    private void toastCancelCreation(int intString) {
        Toast toastCreateMeeting = Toast.makeText( getApplicationContext(), intString, Toast.LENGTH_LONG );
        toastCreateMeeting.setGravity( Gravity.CENTER, 0, 0 );
        View toastViewCreateMeeting = toastCreateMeeting.getView();
        TextView toastTextCreateMeeting = toastViewCreateMeeting.findViewById( android.R.id.message );
        toastTextCreateMeeting.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.addMeeting ) );

        toastCreateMeeting.show();
    }

    // Get Date & Time from the pickers
    private Date getStartMeetingDateTimeFromSelection() {
        // Creating a calendar
        Calendar mCalendar = Calendar.getInstance();
        // Replacing with a new value - date from datePicker, time from timePicker
        mCalendar.setTime( datePickerCalendar.getTime() );
        mCalendar.set( Calendar.HOUR, timePickerCalendar.get( Calendar.HOUR ) );
        mCalendar.set( Calendar.MINUTE, timePickerCalendar.get( Calendar.MINUTE ) );
        return mCalendar.getTime();
    }

    private Date getEndMeetingDateTimeFromSelection() {
        Calendar mCalendar = Calendar.getInstance();
        System.out.println( "startdate : " + mStartDate );
        mCalendar.setTime( mStartDate );
        mCalendar.add( Calendar.HOUR_OF_DAY, durationHours.getValue() );
        mCalendar.add( Calendar.MINUTE, durationMinutes.getValue() * DURATION_STEP_MINUTES );
        System.out.println( "date format : " + mCalendar.getTime() );
        return mCalendar.getTime();
    }

    /*************************************** MENU *****************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.create_meeting, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_button_create_meeting) {
            createMeeting();
            return true;
        }// If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        return super.onOptionsItemSelected( item );
    }
}