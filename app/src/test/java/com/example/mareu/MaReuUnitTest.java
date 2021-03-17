package com.example.mareu;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.mareu.Model.Meeting;
import com.example.mareu.ViewModels.MeetingViewModel;

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


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MaReuUnitTest {
    private MeetingViewModel viewModel;


    // @Before
    // public void setup() throws ParseException {
    //     List<Meeting> lMeetings = Meeting.generateMeetings();
    //     int listSize = lMeetings.size();
    //   }
    /**
     * Test thats the generate listMmeeting function creates a new list comporting 5 items
     */
    @Test
    public void generateListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int listSize = lMeetings.size();
        assertEquals( 20, listSize );
    }

    /**
     * Test thats the add meeting function creates a new meeting to the list
     */
    @Test
    public void addListWithSuccess() throws ParseException {
        viewModel = new MeetingViewModel();

        List<Meeting> lMeetings = Meeting.generateMeetings();
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        int mAnnee = 2021;
        int mMois = (int) (Math.random() * (11));
        int mJour = (int) (Math.random() * (27));
        int mHourDeb = (int) (Math.random() * (23));
        int mHourFin = mHourDeb + 1;
        if (mHourDeb >= 23) {
            mHourFin = 1;
            mJour++;
        }
        int mMinute = (int) (Math.random() * (58));
        int idRoom = (int) (Math.random() * (10));
        String mSubjectMeeting = "1 ere réunion ajoutée";
        mCalendarDeb.set( mAnnee, mMois, mJour, mHourDeb, mMinute );
        mCalendarFin.set( mAnnee, mMois, mJour, mHourFin, mMinute );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting1 = new Meeting( System.currentTimeMillis(),
                idRoom +1,
                mSubjectMeeting,
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 13, 12, 11, 10, 9, 8, 7 )
        );
        try {
            viewModel.addMeeting( aMeeting1 );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int listSize = lMeetings.size();
        assertEquals( 21, listSize );
    }

    public void InitListe() {
        List<Meeting> lMeetings = new ArrayList<>();
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 03, 12, 10, 00 );
        mCalendarDeb.set( 2021, 03, 12, 11, 00 );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion 1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 9, 5 ) );
        lMeetings.add( aMeeting );
    }

}

