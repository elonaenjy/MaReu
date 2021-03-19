package com.example.mareu;

import com.example.mareu.Activity.AddMeetingActivity;
import com.example.mareu.Model.Meeting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MaReuUnitTest {

    @Before
     public void setup() throws ParseException {
         List<Meeting> lMeetings = initListe();
         int listSize = lMeetings.size();
       }


    /**
     * Test thats the generate listMmeeting is called when the activity begins the first time. So the list must be empty
     */
    @Test
    public void generateListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int listSize = lMeetings.size();
        assertEquals( 20, listSize );
    }

    /**
     * Test thats the add meeting function creates a new meeting to the list with a empty list
     */
    @Test
    public void addListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int debSize = lMeetings.size();

        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Sujet de la reunion",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );
        int finSize = lMeetings.size();
        int diffSize = finSize - debSize;
        assertEquals( 1, diffSize );
    }


    /**
     * Test  the FilterMeeting by Room  with a initlist with 7 itemst
     */
    public void FilterbyRoom() {
        List<Meeting> lMeetings = initListe();
        List<Integer> lRoomSelectedId = Arrays.asList( 1, 2, 3 );
        Assert.assertEquals( AddMeetingActivity. );
    }

        // We create a list for each meeting, to check the list returned just contain the linked meeting
        List<Meeting> listOne = new ArrayList<Meeting>( Collections.singleton(mMeetingOne));
        List<Meeting> listTwo = new ArrayList<Meeting>(Collections.singleton(mMeetingTwo));
        List<Meeting> listThree = new ArrayList<Meeting>(Collections.singleton(mMeetingThree));

        calendar.set(2020, 5, 10, 8, 0); // meetingOne
        // What is returned should just contain the meeting one
        Assert.assertEquals(apiService.filterMeetingsByDate(calendar), listOne);
        // and so meeting2 and meeting3 are not in the List
        Assert.assertFalse(apiService.filterMeetingsByDate(calendar).contains(mMeetingTwo));
        Assert.assertFalse(apiService.filterMeetingsByDate(calendar).contains(mMeetingThree));

        calendar.set(2020, 5, 11, 8, 0); // meetingTwo
        Assert.assertEquals(apiService.filterMeetingsByDate(calendar), listTwo);

        calendar.set(2020, 5, 12, 8, 0); // meetingThree
        Assert.assertEquals(apiService.filterMeetingsByDate(calendar), listThree);

        calendar.set(9999, 9, 9, 8, 0);
        // No Meeting should fit that date, so the list returned should be empty
        Assert.assertTrue(apiService.filterMeetingsByDate(calendar).isEmpty());

    }




    private List<Meeting> initListe() {
        List<Meeting> lMeetings = new ArrayList<>();
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion 1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                2,
                "Objet Reunion 2",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 9, 5 ) );
        lMeetings.add( aMeeting );
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                3,
                "Objet Reunion 3",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 6,7,8 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion 4",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,5 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                5,
                "Objet Reunion 5",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
         aMeeting = new Meeting( System.currentTimeMillis(),
                6,
                "Objet Reunion 6",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 5,6,7,8,10) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                7,
                "Objet Reunion 7",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );

        return lMeetings;
    }

}

