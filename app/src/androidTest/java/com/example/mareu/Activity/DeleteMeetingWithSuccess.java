package com.example.mareu.Activity;


import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.R;
import com.example.mareu.utils.DeleteViewAction;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsAnything;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DeleteMeetingWithSuccess {
    private static int INITIAL_LIST_SIZE = 0;

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>( StartActivity.class );

    @Test
    public void deleteMeetingWithSuccess() {

        // Given : We check that the count of items is equal to INITIAL_LIST_SIZE
        onView( withId( R.id.list_recycler_view ) ).check( withItemCount( 0 ) );
        // Click on the creation button for a new meeting
        onView( withId( R.id.button_add_meeting ) )
                .perform( click() );
        // SUBJECT FILLING
        onView( withId( R.id.edit_text_add_meeting_subject ) )
                .perform( click() );
        onView( withId( R.id.edit_text_add_meeting_subject ) )
                .perform( typeText( "New meeting 1" ) );
        // START DATE FILLING
        onView( withId( R.id.text_add_meeting_datepicker ) )
                .perform( click() );
        onView( withClassName( Matchers.equalTo( DatePicker.class.getName() ) ) ).perform( PickerActions.setDate( 2021, 3, 1 ) );
        onView( withText( "OK" ) ).perform( click() );
        // START TIME FILLING
        onView( withId( R.id.text_add_meeting_timepicker ) )
                .perform( click() );
        onView( withClassName( Matchers.equalTo( TimePicker.class.getName() ) ) ).perform( PickerActions.setTime( 15, 0 ) );
        onView( withText( "OK" ) ).perform( click() );
        // DURATION FILLING
        onView( withId( R.id.numberpicker_add_meeting_duration_hours_ ) )
                .perform( new GeneralClickAction( Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0 ) );
        onView( withId( R.id.numberpicker_add_meeting_duration_minutes_ ) )
                .perform( new GeneralClickAction( Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0 ) );
        // ROOM FILLING
        onView( withId( R.id.spinner_add_meeting_room ) )
                .perform( click() );
        onData( IsAnything.anything() ).atPosition( 1 ).perform( click() );
        // GUESTS FILLING
        onView( withId( R.id.autocomplete_text_add_meeting_guests ) )
                .perform( typeText( "f" ) );
        onData( IsAnything.anything() ).atPosition( 1 ).perform( click() );

        // Click on the creation button for a new meeting
        onView( withId( R.id.menu_overflow_button_create_meeting ) )
                .perform( click() );
        // Click on the item menu filter by date
        onView( withText( R.string.menu_creation_meeting ) )
                .perform( click() );
        // Result : We check that the count of items is equal to INITIAL_LIST_SIZE+1
        onView( withId( R.id.list_recycler_view ) ).check( withItemCount( 1 ) );

        // Click on the creation button for a new meeting
        onView( withId( R.id.button_add_meeting ) )
                .perform( click() );
        // SUBJECT FILLING
        onView( withId( R.id.edit_text_add_meeting_subject ) )
                .perform( click() );
        onView( withId( R.id.edit_text_add_meeting_subject ) )
                .perform( typeText( "New meeting 2" ) );
        // START DATE FILLING
        onView( withId( R.id.text_add_meeting_datepicker ) )
                .perform( click() );
        onView( withClassName( Matchers.equalTo( DatePicker.class.getName() ) ) ).perform( PickerActions.setDate( 2021, 3, 6 ) );
        onView( withText( "OK" ) ).perform( click() );
        // START TIME FILLING
        onView( withId( R.id.text_add_meeting_timepicker ) )
                .perform( click() );
        onView( withClassName( Matchers.equalTo( TimePicker.class.getName() ) ) ).perform( PickerActions.setTime( 15, 0 ) );
        onView( withText( "OK" ) ).perform( click() );
        // DURATION FILLING
        onView( withId( R.id.numberpicker_add_meeting_duration_hours_ ) )
                .perform( new GeneralClickAction( Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0 ) );
        onView( withId( R.id.numberpicker_add_meeting_duration_minutes_ ) )
                .perform( new GeneralClickAction( Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0 ) );
        // ROOM FILLING
        onView( withId( R.id.spinner_add_meeting_room ) )
                .perform( click() );

        onData( IsAnything.anything() ).atPosition( 2 ).perform( click() );
        // GUESTS FILLING
        onView( withId( R.id.autocomplete_text_add_meeting_guests ) )
                .perform( typeText( "f" ) );
        onData( IsAnything.anything() ).atPosition( 1 ).perform( click() );

        // Click on the creation button for a new meeting
        onView( withId( R.id.menu_overflow_button_create_meeting ) )
                .perform( click() );
        // Click on the item menu filter by date
        onView( withText( R.string.menu_creation_meeting ) )
                .perform( click() );
        // Result : We check that the count of items is equal to INITIAL_LIST_SIZE+1
        onView( withId( R.id.list_recycler_view ) ).check( withItemCount( 2 ) );


        // Push on delete button for meeting at index = 1
        onView(withId(R.id.list_recycler_view))
                .perform( RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount( 1));

    }


}

