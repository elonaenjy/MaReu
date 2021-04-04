package com.example.mareu.Activity;



import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.R;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsAnything;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.InstrumentedTest.childAtPosition;
import static com.example.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FilterByDateWithSuccess {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>( StartActivity.class );

    @Test
    public void filterByRoomWithSuccess() {

        // Given : We check that the count of items is equal to INITIAL_LIST_SIZE
        onView( ViewMatchers.withId( R.id.list_recycler_view ) ).check( withItemCount( 0 ) );
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
        onView(allOf( withId( android.R.id.button1 ), withText( "OK"),
                childAtPosition(
                        childAtPosition(
                                withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                0 ),
                        3 ) ) ).perform(click() );

//      onView( withText( "OK" ) ).perform( click() );
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
        // GUESTS FILLING
        onView( withId( R.id.autocomplete_text_add_meeting_guests ) )
                .perform( typeText( "f" ) );
        onData( anything() ).atPosition( 1 ).perform( click() );

        // ROOM FILLING
        onView(withId(R.id.spinner_add_meeting_room))
                .perform(click());
        onData(anything()).atPosition(4).perform(click());

        // Click on the creation button for a new meeting
        onView( withId( R.id.menu_overflow_button_create_meeting ) )
                .perform( click() );
        // Click on the item menu filter by date
        onView( withText( R.string.menu_creation_meeting ) )
                .perform( click() );
        // Result : We check that the count of items is equal to 1
        onView( withId( R.id.list_recycler_view ) ).check( withItemCount( 1 ) );


        // Ajout seconde réunion

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
        // GUESTS FILLING
        onView( withId( R.id.autocomplete_text_add_meeting_guests ) )
                .perform( typeText( "f" ) );
        onData( anything() ).atPosition( 1 ).perform( click() );

        // ROOM FILLING
        onView(withId(R.id.spinner_add_meeting_room))
                .perform(click());
        onData(anything()).atPosition(5).perform(click());

        // Click on the creation button for a new meeting
        onView( withId( R.id.menu_overflow_button_create_meeting ) )
                .perform( click() );
        // Click on the item menu filter by date
        onView( withText( R.string.menu_creation_meeting ) )
                .perform( click() );
        // Result : We check that the count of items is equal to INITIAL_LIST_SIZE+1
        onView( withId( R.id.list_recycler_view ) ).check( withItemCount( 2 ) );
//////// filtre

        onView(allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) ).perform( click() );


        onView(allOf( withId( R.id.title ), withText( "Filtrer par date" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) ).perform( click() );

        onView(allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) ).perform(click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 600 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.list_recycler_view)).check(withItemCount(1));

        ViewInteraction actionMenuItemView2 = onView(
                allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        actionMenuItemView2.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 650 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView2 = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par date" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView2.perform( click() );

        ViewInteraction materialButton2 = onView(
                allOf( withId( android.R.id.button3 ), withText( "Réinitialiser le filtre" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                0 ) ) );
        materialButton2.perform( scrollTo(), click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 600 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView3 = onView(
                allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        actionMenuItemView3.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 650 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView3 = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par date" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView3.perform( click() );

        ViewInteraction materialButton3 = onView(
                allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) );
        materialButton3.perform( scrollTo(), click() );
        onView(withId(R.id.list_recycler_view)).check(withItemCount(1));


    }


}

