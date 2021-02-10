package com.example.mareu.Model;


import android.text.format.Time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Meeting implements Serializable {

        /** Identifier */
        private long idMeeting;

        /** Identifier */
        private long idRoom;

        /** Full subject */
        private String subject;

        /** date */
        private Date meetingDate;

        /** heure début */
        private Time meetingTimeDebut;

        /** heure fin */
        private Time meetingTimeFin;

        /** liste des participants */
        public ArrayList participants = new ArrayList();

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

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Date getMeetingDate() {
            return meetingDate;
        }

        public void setMeetingDate(Date meetingDate) {
            this.meetingDate = meetingDate;
        }

        public Time getMeetingTimeDebut() {
            return meetingTimeDebut;
        }

        public void setMeetingTimeDebut(Time meetingTimeDebut) {
            this.meetingTimeDebut = meetingTimeDebut;
        }

        public Time getMeetingTimeFin() {
            return meetingTimeFin;
        }

        public void setMeetingTimeFin(Time meetingTimeFin) {
            this.meetingTimeFin = meetingTimeFin;
        }

        public ArrayList getParticipants() {
            return participants;
        }

        public void setParticipants(ArrayList participants) {
            this.participants = participants;
        }

    /**
         * Constructor
         * @param idMeeting
         * @param idRoom
         * @param subject
         * @param meetingDate
         * @param meetingTimeDebut
         * @param meetingTimeFin
         * @param participants

         */
        public Meeting(long idMeeting, long idRoom, String subject, Date meetingDate, Time meetingTimeDebut, Time meetingTimeFin, ArrayList participants) {
            this.idMeeting = idMeeting;
            this.idRoom = idRoom;
            this.meetingDate = meetingDate;
            this.meetingTimeDebut = meetingTimeDebut;
            this.meetingTimeFin = meetingTimeFin;
            this.participants = participants;
            this.subject = subject;

        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Meeting room = (Meeting) o;
            return Objects.equals(idMeeting,room.idMeeting);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idMeeting);
        }

    }


