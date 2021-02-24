package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

public class Meeting {

    private static List<Meeting> DUMMY_MEETINGS;

    static {
        DUMMY_MEETINGS = asList(
                new Meeting(
                        1,
                        4,
                        "Objet Réunion 1",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 1, 2, 3, 4 )
                ),
                new Meeting(
                        2,
                        3,
                        "Objet Réunion 2",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 4, 5, 6, 8 )
                ),
                new Meeting(
                        3,
                        5,
                        "Objet Réunion 3",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 13, 12, 11, 10, 9, 8, 7 )
                ),
                new Meeting(
                        4,
                        6,
                        "Objet Réunion 4",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 14, 15 )
                ),
                new Meeting(
                        5,
                        3,
                        "Objet Réunion 5",
                        new Date( 1623247200000L ),
                        new Date( 1623250800000L ),
                        Arrays.asList( 9, 5 )
                )
        );
    }

    public static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    public int idMeeting;

    public int idRoom;

    public String meetingSubject;

    public Date meetingStartDate;

    public Date meetingEndDate;

    public List<Integer> meetingGuestListId;

    public Meeting(int idMeeting, int idRoom, String meetingSubject, Date meetingStartDate, Date meetingEndDate, List<Integer> meetingGuestListId) {
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