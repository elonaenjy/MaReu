package com.example.mareu.Model;


import android.text.format.Time;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Meeting {

        /** Identifier */
        private long idMeeting;

        /** Identifier */
        private long idRoom;

        /** Full subject */
        private String subject;

        /** date */
        private DateFormat meetingDate;

        /** liste des participants */
        public String participants;

    public Meeting(int i, int i1, Date dateReunion, String s, String objet_réunion) {
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

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public DateFormat getMeetingDate() {
            return meetingDate;
        }

        public void setMeetingDate(DateFormat meetingDate) {
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
     */
        public Meeting() {
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


