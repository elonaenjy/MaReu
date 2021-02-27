package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.List;

public class Meeting {

    public static List<Meeting> generateMeetings() {
        ArrayList<Meeting> lMeetings = new ArrayList<Meeting>();

        Meeting eMeeting = new Meeting( 5,
                3,
                "Objet Réunion 5",
                new Date( 1623247200000L ),
                new Date( 1623250800000L ),
                Arrays.asList( 9, 5 ));

        lMeetings.add( eMeeting );

        eMeeting = new Meeting(
                2,
                3,
                "Objet Réunion 2",
                new Date( 1623247200000L ),
                new Date( 1623250800000L ),
                Arrays.asList( 4, 5, 6, 8 ));

        lMeetings.add( eMeeting );
        eMeeting = new Meeting(
                        3,
                        5,
                        "Objet Réunion 3",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 13, 12, 11, 10, 9, 8, 7 )
                );

        lMeetings.add( eMeeting );

        eMeeting = new Meeting(
                        4,
                        6,
                        "Objet Réunion 4",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 14, 15 )
                );

        lMeetings.add( eMeeting );

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

//    public void createMeeting(Meeting meeting) {
//        lMeetings.add(meeting);
//    }
    public static void deleteMeeting(ArrayList<Meeting> lMeetings, Meeting meeting) {
        lMeetings.remove(meeting);
    }
}