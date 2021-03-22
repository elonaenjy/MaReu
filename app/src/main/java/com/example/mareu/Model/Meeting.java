package com.example.mareu.Model;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Meeting implements Serializable {

    public static List<Meeting> generateMeetings() throws ParseException {
        List<Meeting> lMeetings = new ArrayList<Meeting>();

//        for (int j = 0; j<20 ; j++){
//            Meeting aMeeting = alimMeeting(j);
//            lMeetings.add( aMeeting );
//        }
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
                Arrays.asList( 3,4,6 ) );
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
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
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
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion 4",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,5, 6 ) );
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
                Arrays.asList( 5,6,7,8,10) );
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
                Arrays.asList( 1,2,3,4,9, 5 ) );
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
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );
        return lMeetings;
    }

    private static Meeting alimMeeting(int j) {
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
        String mSubjectMeeting = "Objet de la reunion " + j;
        mCalendarDeb.set( mAnnee, mMois, mJour, mHourDeb, mMinute );
        mCalendarFin.set( mAnnee, mMois, mJour, mHourFin, mMinute );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                idRoom +1,
                mSubjectMeeting,
                 dateDebMeeting,
                 dateFinMeeting,
                Arrays.asList( 9, 5 ));

         return aMeeting;
    }

    public long idMeeting;

    public int idRoom;

    public String meetingSubject;

    public Date meetingStartDate;

    public Date meetingEndDate;

    public List<Integer> meetingGuestListId;

    public Meeting(long idMeeting, int idRoom, String meetingSubject, Date meetingStartDate, Date meetingEndDate, List<Integer> meetingGuestListId) {
        this.idMeeting = idMeeting;
        this.idRoom = idRoom;
        this.meetingSubject = meetingSubject;
        this.meetingStartDate = meetingStartDate;
        this.meetingEndDate = meetingEndDate;
        this.meetingGuestListId = meetingGuestListId;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public Date getMeetingStartDate() {
        return meetingStartDate;
    }

    public Date getMeetingEndDate() {
        return meetingEndDate;
    }

    public List<Integer> getMeetingGuestListId() {
        return meetingGuestListId;
    }

}