package com.example.mareu.Model;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    private final List<Meeting> lMeetings = Meeting.generateMeetings();
    private final List<Guest> lGuests = Guest.generateGuests();
    private final List<Room> lRooms = Room.generateRooms();

    public List<Meeting> getMeetings() { return lMeetings;   }

    public void deleteMeeting(Meeting meeting) {
        this.lMeetings.remove(meeting);
    }

    public void addMeeting(Meeting meeting) {
        this.lMeetings.add(meeting);
    }

    public List<Guest> getGuests() {
        return this.lGuests;
    }

    public List<Room> getRooms() {
        return this.lRooms;
    }





}
