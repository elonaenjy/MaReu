package com.example.mareu.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Meeting>> lMeetings;
    public LiveData<List<Meeting>> getMeeting() {
        if (lMeetings == null) {
            lMeetings = new MutableLiveData<List<Meeting>>();
            Meeting.generateMeetings();
        }
        return lMeetings;
    }

    private MutableLiveData<List<Guest>> lGuests;
    public LiveData<List<Guest>> getGuest() {
        if (lGuests == null) {
            lGuests = new MutableLiveData<List<Guest>>();
            Guest.generateGuests();
        }
        return lGuests;
    }

    private MutableLiveData<List<Room>> lRooms;
    public LiveData<List<Room>> getRoom() {
        if (lRooms == null) {
            lRooms = new MutableLiveData<List<Room>>();
            Room.generateRooms();
        }
        return lRooms;
    }


//    public void deleteMeeting(Meeting meeting) {
//        this.lMeetings.remove(meeting);
//    }

//    public void addMeeting(Meeting meeting) {
//        this.lMeetings.add(meeting);
//    }

    }





}
