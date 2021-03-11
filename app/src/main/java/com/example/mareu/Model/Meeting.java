package com.example.mareu.Model;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Meeting extends ArrayList<Parcelable> implements Serializable {

    public static List<Meeting> generateMeetings() throws ParseException {
        List<Meeting> lMeetings = new ArrayList<Meeting>();

        Meeting eMeeting = new Meeting( 1,
                1,
                "Objet Réunion 1",
                new Date( 1623247200000L ),
                new Date( 1623250800000L ),
                Arrays.asList( 9, 5 ));

        lMeetings.add(eMeeting );

        eMeeting = new Meeting(
                2,
                3,
                "Objet Réunion 2",
                new Date( 1623247200000L ),
                new Date( 1623250800000L ),
                Arrays.asList( 4, 5, 6, 8 ));

        lMeetings.add(eMeeting );

        eMeeting = new Meeting(
                        3,
                        5,
                        "Objet Réunion 3",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 13, 12, 11, 10, 9, 8, 7 )
                );

        lMeetings.add(eMeeting );

        String dateValue = "04/02/2011 20:27:05";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //  04/02/2011 20:27:05
        Date dateDeb = sdf.parse(dateValue); // returns date object
        dateValue = "04/02/2011 21:27:05";
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //  04/02/2011 20:27:05
        Date dateFin = sdf.parse(dateValue); // returns date object

        eMeeting = new Meeting(
                        4,
                        6,
                        "Objet Réunion 4",
                        new Date( String.valueOf( dateDeb ) ),
                        new Date( String.valueOf( dateFin ) ),
                        Arrays.asList( 14, 15 )
                );

        lMeetings.add(eMeeting );

        eMeeting = new Meeting(
                        5,
                        3,
                        "Objet Réunion 5",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 9, 5 )
                );

        lMeetings.add( eMeeting );
        return lMeetings;
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