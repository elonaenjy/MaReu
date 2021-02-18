package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Meeting {

    private static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting( 1,4,  "Objet Réunion 1",
                    new java.sql.Date(Long.parseLong("1623247200000")),
                    new java.sql.Date(Long.parseLong("1623250800000")),
                    ("Marie, Henri, Remy, Fanny, Paul, Henri")
            ),
            new Meeting( 2,3,  "Objet Réunion 2",
                    new java.sql.Date(Long.parseLong("1623247200000")),
                    new java.sql.Date(Long.parseLong("1623250800000")),
                    ("Helene, Elodie")
            ),
            new Meeting( 3, 2, "Objet Réunion 3",
                    new java.sql.Date(Long.parseLong("1613395800000")),
                    new java.sql.Date(Long.parseLong("1613399400000")),
                    ("Dominique, Gertrude, Laura")
            ),
            new Meeting( 4, 1, "Objet Réunion 4",
                    new java.sql.Date(Long.parseLong("1613397600000")),
                    new java.sql.Date(Long.parseLong("1613399400000")),
                    ("Fanny, Paul, Henri")
            )
    );

    public static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }


    /**
     * Identifier
     */
    public int idMeeting;

    /**
     * Identifier
     */
    public int idRoom;

    /**
     * Full subject
     */
    public String meetingSubject;

    /**
     * date
     */
    public Date meetingDateDebut;

    /**
     * date
     */
    public Date meetingDateFin;

    /**
     * liste des participants
     */
    public String meetingGuestList;

    public Meeting(int idMeeting, int idRoom, String meetingSubject, Date meetingDateDebut, Date meetingDateFin, String meetingGuestList) {
        this.idMeeting = idMeeting;
        this.idRoom = idRoom;
        this.meetingSubject = meetingSubject;
        this.meetingDateDebut = meetingDateDebut;
        this.meetingDateFin = meetingDateFin;
        this.meetingGuestList = meetingGuestList;
    }

    public long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(int idMeeting) {
        this.idMeeting = idMeeting;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public Date getMeetingDateDebut() {
        return meetingDateDebut;
    }

    public void setMeetingDateDebut(Date meetingDateDebut) {
        this.meetingDateDebut = meetingDateDebut;
    }

    public Date getMeetingDateFin() {
        return meetingDateFin;
    }

    public void setMeetingDateFin(Date meetingDateFin) {
        this.meetingDateFin = meetingDateFin;
    }

    public String getMeetingGuestList() {
        return meetingGuestList;
    }

    public void setMeetingGuestList(String meetingGuestList) {
        this.meetingGuestList = meetingGuestList;
    }
}