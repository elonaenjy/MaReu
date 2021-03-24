package com.example.mareu;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.mareu.Activity.StartActivity;
import com.example.mareu.Model.Meeting;
import com.example.mareu.utils.DeleteViewAction;
import com.example.mareu.Activity.ListMeetingActivity;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    private static int INITIAL_LIST_SIZE = 0;

    static {
        try {
            INITIAL_LIST_SIZE = Meeting.generateMeetings().size();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public final ActivityTestRule<StartActivity> mActivityRule =
            new ActivityTestRule<>(StartActivity.class);

    @Before
    public void setUp() {
        StartActivity mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }


    /**
     * We ensure that our recyclerview is displaying at least on item when we launch the app with an init liste
     */
    @Test
    public void MaReuList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_recycler_view)).check(matches(hasMinimumChildCount(1)));
    }

    // Verify the add action contributes to create a new item in the list
    @Test
    public void addMeetingWithSucess() {
        // Given : We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE));
        // Click on the creation button for a new meeting
        onView(withId(R.id.button_add_meeting))
                .perform(click());
        // SUBJECT FILLING
        onView(withId(R.id.edit_text_add_meeting_subject))
                .perform(click());
        onView(withId(R.id.edit_text_add_meeting_subject))
                .perform(typeText("New meeting"));
        // START DATE FILLING
        onView(withId(R.id.text_add_meeting_datepicker))
                .perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 6, 6));
        onView(withText("OK")).perform(click());
        // START TIME FILLING
        onView(withId(R.id.text_add_meeting_timepicker))
                .perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(15, 0));
        onView(withText("OK")).perform(click());
        // DURATION FILLING
        onView(withId(R.id.numberpicker_add_meeting_duration_hours_))
                .perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0));
        onView(withId(R.id.numberpicker_add_meeting_duration_minutes_))
                .perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0));
        // ROOM FILLING
        onView(withId(R.id.spinner_add_meeting_room))
                .perform(click());
        onData(anything()).atPosition(1).perform(click());
        // GUESTS FILLING
        onView(withId(R.id.autocomplete_text_add_meeting_guests))
                .perform(typeText("f"));
        onData(anything()).atPosition(1).perform(click());

        // Click on the creation button for a new meeting
        onView(withId(R.id.menu_overflow_button_create_meeting))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText(R.string.menu_creation_meeting))
                .perform(click());
        // Result : We check that the count of items is equal to INITIAL_LIST_SIZE+1
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE + 1));
    }

    // Verify a subject is given
    @Test
    public void addMeetingWithMissingSubjectThrowsToast() {
        // Click on the creation button for a new meeting
        onView(withId(R.id.button_add_meeting))
                .perform(click());

        // Click on the creation button for a new meeting
        onView(withId(R.id.menu_overflow_button_create_meeting))
                .perform(doubleClick());

        // Result : We check that the Toast is displayed on screen
        onView(withText(R.string.toast_subject_empty)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    // Verify the room is not available
    @Test
    public void addMeetingWithNotAvailableRoomThrowsToast() {
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE));

        // Click on the creation button for a new meeting
        onView(withId(R.id.button_add_meeting))
                .perform(click());
        // SUBJECT FILLING
        onView(withId(R.id.edit_text_add_meeting_subject))
                .perform(click());
        onView(withId(R.id.edit_text_add_meeting_subject))
                .perform(typeText("New meeting"));
        // START DATE FILLING
        onView(withId(R.id.text_add_meeting_datepicker))
                .perform(click());
        onView(withClassName( Matchers.equalTo( DatePicker.class.getName()))).perform( PickerActions.setDate(2021,3 , 12));
        onView(withText("OK")).perform(click());
        // START TIME FILLING
        onView(withId(R.id.text_add_meeting_timepicker))
                .perform(click());
        onView(withClassName(Matchers.equalTo( TimePicker.class.getName()))).perform(PickerActions.setTime(10, 30));
        onView(withText("OK")).perform(click());
        // DURATION FILLING
        onView(withId(R.id.numberpicker_add_meeting_duration_hours_))
                .perform(new GeneralClickAction( Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0));
        onView(withId(R.id.numberpicker_add_meeting_duration_minutes_))
                .perform(new GeneralClickAction(Tap.SINGLE, GeneralLocation.TOP_CENTER, Press.FINGER, 1, 0));
        // ROOM FILLING
        onView(withId(R.id.spinner_add_meeting_room))
                .perform(click());
        onData(anything()).atPosition(0).perform(click());

        // GUESTS FILLING
        onView(withId(R.id.autocomplete_text_add_meeting_guests))
                .perform(typeText("f"));
        onData(anything()).atPosition(1).perform(click());

        // Click on the creation button for a new meeting
        onView(withId(R.id.menu_overflow_button_create_meeting))
                .perform(click());
        // Click to confirm the création of the meeting
        onView(withText(R.string.menu_creation_meeting))
                .perform(click());

        // Result : We check that the Toast is displayed on screen
        onView(withText(R.string.toast_room_not_available)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    // Verify the delete action suppress one item in the list
    @Test
    public void deleteMeetingWithSuccess() {
        // Given : We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE));
        // Push on delete button for meeting at index = 1
        onView(withId(R.id.list_recycler_view))
                .perform( RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE - 1));
    }

    @Test
    public void filterMeetingByDate() {
        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_create_meeting))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText(R.string.menu_filter_date))
                .perform(click());
        // Pick a date, example 6th may 2020 ( 2 meetings hardcoded in DummyMaReuApiGenerator for this date )
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 5, 6));
        onView(withText(R.string.filter_ok_text)).perform(click());
        // We check that the count of items is 2 <-> Because 2 meetings hardcoded in DummyMaReuApiGenerator
        onView(withId(R.id.list_recycler_view)).check(withItemCount(2));
        // #################### REPEAT for another date picked ! #####################
        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_create_meeting))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText(R.string.menu_filter_date))
                .perform(click());

        // Pick another date, example 6th may 2019 ( 0 meetings ! )
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2019, 5, 6));
        onView(withText(R.string.filter_ok_text)).perform(click());
        // We check that the count of items is 0
        onView(withId(R.id.list_recycler_view)).check(withItemCount(0));
    }


}