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
        private String meetingSubject;

        // Todo : mettre en place dans un format Date à la place des deux strings meetingDate et meetingTime */
        /** date */
        private String meetingDate;

        /** date */
        private String meetingTime;

        /** liste des participants */
        public String meetingParticipants;

        public Meeting(long idMeeting, long idRoom, String meetingSubject, String meetingDate, String meetingTime, String meetingParticipants) {
            this.idMeeting = idMeeting;
            this.idRoom = idRoom;
            this.meetingSubject = meetingSubject;
            this.meetingDate = meetingDate;
            this.meetingTime = meetingTime;
            this.meetingParticipants = meetingParticipants;
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

        public String getMeetingDate() {
            return meetingDate;
        }

        public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

        public void setMeetingTime(String meetingTime) {
            this.meetingTime = meetingTime;
        }

        public String getMeetingTime() {
        return meetingTime;
    }

        public String getMeetingParticipants() {
            return meetingParticipants;
        }

        public void setParticipants(String participants) {
            this.meetingParticipants = participants;
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
