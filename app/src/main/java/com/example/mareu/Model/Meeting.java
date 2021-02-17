package com.example.mareu.Model;

import java.util.Date;

public class Meeting {

    /**
     * Identifier
     */
    public long idMeeting;

    /**
     * Identifier
     */
    public long idRoom;

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

    public Meeting(long idMeeting, long idRoom, String meetingSubject, Date meetingDateDebut, Date meetingDateFin, String meetingGuestList) {
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

    public void setIdMeeting(long idMeeting) {
        this.idMeeting = idMeeting;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
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