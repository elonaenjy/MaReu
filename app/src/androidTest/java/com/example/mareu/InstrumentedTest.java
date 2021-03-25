package com.example.mareu;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.DataInteraction;
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

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
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
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_recycler_view)).check(matches(hasMinimumChildCount(1)));
    }

    // Verify the add action contributes to create a new item in the list
    @Test
    public void addMeetingWithSucess() {
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Given : We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE));
        // Push on delete button for meeting at index = 1
        onView(withId(R.id.list_recycler_view))
                .perform( RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // We check that the count of items is equal to INITIAL_LIST_SIZE
        onView(withId(R.id.list_recycler_view)).check(withItemCount(INITIAL_LIST_SIZE - 1));
    }

    @Test
    public void filtreByDate() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 900 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView = onView(
                allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        actionMenuItemView.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 650 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par date" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView.perform( click() );

        ViewInteraction materialButton = onView(
                allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) );
        materialButton.perform( scrollTo(), click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 600 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.list_recycler_view)).check(withItemCount(0));

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
        onView(withId(R.id.list_recycler_view)).check(withItemCount(0));

    }
    @Test
    public void filterByRoom() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 600 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView = onView(
                allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        actionMenuItemView.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par salle de réunion" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView.perform( click() );

        DataInteraction appCompatCheckedTextView = onData( Matchers.anything() )
                .inAdapterView( allOf( withClassName( Matchers.is( "com.android.internal.app.AlertController$RecycleListView" ) ),
                        childAtPosition(
                                withClassName( Matchers.is( "android.widget.FrameLayout" ) ),
                                0 ) ) )
                .atPosition( 5 );
        appCompatCheckedTextView.perform( click() );

        ViewInteraction materialButton = onView(
                allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) );
        materialButton.perform( scrollTo(), click() );

        onView(withId(R.id.list_recycler_view)).check(withItemCount(1));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 300 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView2 = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par salle de réunion" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView2.perform( click() );

        DataInteraction appCompatCheckedTextView2 = onData( Matchers.anything() )
                .inAdapterView( allOf( withClassName( Matchers.is( "com.android.internal.app.AlertController$RecycleListView" ) ),
                        childAtPosition(
                                withClassName( Matchers.is( "android.widget.FrameLayout" ) ),
                                0 ) ) )
                .atPosition( 5 );
        appCompatCheckedTextView2.perform( click() );

        ViewInteraction materialButton2 = onView(
                allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) );
        materialButton2.perform( scrollTo(), click() );

        ViewInteraction materialButton3 = onView(
                allOf( withId( android.R.id.button3 ), withText( "Réinitialiser le filtre" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                0 ) ) );
        materialButton3.perform( scrollTo(), click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 300 );
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
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView3 = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par salle de réunion" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView3.perform( click() );

        DataInteraction appCompatCheckedTextView3 = onData( Matchers.anything() )
                .inAdapterView( allOf( withClassName( Matchers.is( "com.android.internal.app.AlertController$RecycleListView" ) ),
                        childAtPosition(
                                withClassName( Matchers.is( "android.widget.FrameLayout" ) ),
                                0 ) ) )
                .atPosition( 10 );
        appCompatCheckedTextView3.perform( click() );

        ViewInteraction materialButton4 = onView(
                allOf( withId( android.R.id.button1 ), withText( "Voir" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                3 ) ) );
        materialButton4.perform( scrollTo(), click() );

        onView(withId(R.id.list_recycler_view)).check(withItemCount(0));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 300 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView4 = onView(
                allOf( withId( R.id.menu_overflow_button_create_meeting ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.toolbar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        actionMenuItemView4.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialTextView4 = onView(
                allOf( withId( R.id.title ), withText( "Filtrer par salle de réunion" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        materialTextView4.perform( click() );

        ViewInteraction materialButton5 = onView(
                allOf( withId( android.R.id.button3 ), withText( "Réinitialiser le filtre" ),
                        childAtPosition(
                                childAtPosition(
                                        withClassName( Matchers.is( "android.widget.ScrollView" ) ),
                                        0 ),
                                0 ) ) );
        materialButton5.perform( scrollTo(), click() );
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText( "Child at position " + position + " in parent " );
                parentMatcher.describeTo( description );
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches( parent )
                        && view.equals( ((ViewGroup) parent).getChildAt( position ) );
            }
        };
    }

}