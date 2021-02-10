package com.example.mareu.Model;


import android.text.format.Time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Meeting {

        /** Identifier */
        private long idMeeting;

        /** Identifier */
        private long idRoom;

        /** Full subject */
        private String subject;

        /** date */
        private Date meetingDate;

        /** liste des participants */
        public String participants;

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

        public String getParticipants() {
            return participants;
        }

        public void setParticipants(String participants) {
            this.participants = participants;
        }

    /**
         * Constructor
         * @param idMeeting
         * @param idRoom
         * @param subject
         * @param meetingDate
         * @param participants

         */
        public Meeting(long idMeeting, long idRoom, String subject, Date meetingDate,  String participants) {
            this.idMeeting = idMeeting;
            this.idRoom = idRoom;
            this.meetingDate = meetingDate;
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


