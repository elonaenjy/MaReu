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
        int idRoom = 0;
        for (int j = 0; j<20 ; j++){
            Meeting aMeeting = alimMeeting(j);
            lMeetings.add( aMeeting );
            System.out.println(aMeeting.getIdMeeting()+ "" + aMeeting.getMeetingSubject() + aMeeting.meetingStartDate + aMeeting.getMeetingEndDate());
        }
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

    public long idRoom;

    public String meetingSubject;

    public Date meetingStartDate;

    public Date meetingEndDate;

    public List<Integer> meetingGuestListId;

    public Meeting(long idMeeting, long idRoom, String meetingSubject, Date meetingStartDate, Date meetingEndDate, List<Integer> meetingGuestListId) {
        this.idMeeting = idMeeting;
        this.idRoom = idRoom;
        this.meetingSubject = meetingSubject;
        this.meetingStartDate = meetingStartDate;
        this.meetingEndDate = meetingEndDate;
        this.meetingGuestListId = meetingGuestListId;
    }

    public long getIdMeeting() {
        return idMeeting;
    }

    public long getIdRoom() {
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