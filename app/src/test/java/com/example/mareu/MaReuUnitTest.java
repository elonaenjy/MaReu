package com.example.mareu;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Util.Repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MaReuUnitTest {

    private Date datePicker;

    /**
     * Test thats the generate listMmeeting is empty at the lauching of the application
     */
    @Test
    public void generateEmptyList() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int listSize = lMeetings.size();
        assertEquals( 0, listSize );
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
                Arrays.asList( 3, 4, 6 ) );

        Repository.addMeeting( aMeeting, lMeetings );
        assertTrue( lMeetings.contains( aMeeting ) );

        int finSize = lMeetings.size();
        int diffSize = finSize - debSize;
        assertEquals( 1, diffSize );

    }
    /**
     * Test thats the add meeting function creates a new meeting to the list with a empty list
     */
    @Test
    public void removeListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = initListe();
        int debSize = lMeetings.size();

        Meeting meetingToDelete = lMeetings.get(0);
        lMeetings.remove(meetingToDelete);
        assertFalse( lMeetings.contains( meetingToDelete ) );
        int finSize = lMeetings.size();
        int diffSize = debSize - finSize;
        assertEquals( 1, diffSize );

    }

    /**
     * Test  the FilterMeeting by Room  with a initlist with 7 items
     */
    @Test
    public void FilterbyRoom() {
        List<Meeting> lMeetings = initListe();
        List<Integer> lRoomSelectedId = Arrays.asList( 1, 9 );
        List<Meeting> lMeetingFiltered = new ArrayList<>();

        lMeetingFiltered = Repository.lMeetingsFilteredId( lRoomSelectedId, lMeetings );

        int nbMeetingFiltered = lMeetingFiltered.size();
        assertEquals( 2, nbMeetingFiltered );
    }

    /**
     * Test  the FilterMeeting by Date with a initlist with 7 items
     */
    @Test
    public void FilterByDate() {
        List<Meeting> lMeetings = initListe();

        Calendar mCalendarPicker = Calendar.getInstance();
        mCalendarPicker.set( 2021, 02, 20, 10, 00 );
        List<Meeting> lMeetingsFiltered = Repository.filterMeetingsByDate( 2021, 02, 20, lMeetings );
        int nbMeetingSelected = lMeetingsFiltered.size();
        assertEquals( 1, nbMeetingSelected );
    }

    /**
     * Test  the availability of a room
     */
    @Test
    public void checkRoomAvailability() {
        List<Meeting> lMeetings = initListe();
        int idRoom = 1;
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 30 );
        mCalendarFin.set( 2021, 02, 12, 11, 30 );
        Date mStartDate = new Date( mCalendarDeb.getTimeInMillis() );
        Date mEndDate = new Date( mCalendarFin.getTimeInMillis() );
        boolean available = Repository.checkRoomAvailability( idRoom, mStartDate, mEndDate, lMeetings );
        assertEquals( false, available );

        mCalendarDeb = Calendar.getInstance();
        mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 01, 01, 07, 30 );
        mCalendarFin.set( 2021, 01, 01, 10, 30 );
        mStartDate = new Date( mCalendarDeb.getTimeInMillis() );
        mEndDate = new Date( mCalendarFin.getTimeInMillis() );
        available = Repository.checkRoomAvailability( idRoom, mStartDate, mEndDate, lMeetings );
        assertEquals( true, available );

    }
    public List<Meeting> initListe() {
        List<Meeting> lMeetings = new ArrayList<>();
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion 1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3, 4, 6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 20, 10, 00 );
        mCalendarDeb.set( 2021, 02, 20, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion filtre sur date1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3, 4, 6 ) );
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
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                3,
                "Objet Reunion 3",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 6, 7, 8 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion 4",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3, 4, 5 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
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
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                6,
                "Objet Reunion 6",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 5, 6, 7, 8, 10 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                7,
                "Objet Reunion 7",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2, 3, 4, 9, 5 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 13, 10, 00 );
        mCalendarFin.set( 2021, 02, 13, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                10,
                "Objet Reunion 8",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2, 3, 4, 9, 5 ) );
        lMeetings.add( aMeeting );


        mCalendarDeb.set( 2021, 02, 13, 14, 00 );
        mCalendarFin.set( 2021, 02, 13, 15, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion apres midi",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2, 3, 4, 9, 5 ) );
        lMeetings.add( aMeeting );

        return lMeetings;
    }
}
