package com.example.mareu.Model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mareu.Activity.ListMeetingActivity;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private MutableLiveData<List<Meeting>> lMeetings;
    private MutableLiveData<List<Guest>> lGuests;
    private MutableLiveData<List<Room>> lRooms;

    //*************** ListMeeting data
    public MyViewModel (Application application) {
        super (application);
        lMeetings = new MutableLiveData<>();
        lMeetings.postValue( Meeting.generateMeetings() );
 //       lGuests = new MutableLiveData<>();
 //       lGuests.postValue( Guest.generateGuests() );
 //       lRooms = new MutableLiveData<>();
 //       lRooms.postValue( Room.generateRooms() );
    }
    public MutableLiveData<List<Meeting>> getMeeting() {
                return lMeetings;
        }
    public MutableLiveData<List<Guest>> getGuests() {
        return lGuests;
    }
    public MutableLiveData<List<Room>> getlRooms() {
        return lRooms;
    }


//    public void deleteMeeting(Meeting meeting) {
//        this.lMeetings.remove(meeting);
//    }

//    public void addMeeting(Meeting meeting) {
//        this.lMeetings.add(meeting);
//    }

    }






