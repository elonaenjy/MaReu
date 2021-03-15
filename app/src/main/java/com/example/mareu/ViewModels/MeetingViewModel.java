package com.example.mareu.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mareu.Model.Meeting;

import java.text.ParseException;
import java.util.List;

public class MeetingViewModel extends ViewModel {

    private MutableLiveData<List<Meeting>> lMeetings;
    private MutableLiveData<List<Meeting>> lMeetingsRef;

    public LiveData<List<Meeting>> getMeetings() throws ParseException {
        if(lMeetings == null) {
            lMeetings = new MutableLiveData<List<Meeting>>();
            lMeetingsRef = new MutableLiveData<List<Meeting>>();
            List<Meeting> listMeetingsRef = Meeting.generateMeetings();
            lMeetings.setValue(listMeetingsRef);
            lMeetingsRef.setValue(listMeetingsRef);
        }
        return lMeetings;
    }

    public void addMeeting(Meeting meeting) throws ParseException {
        List<Meeting> newListMeeting = getMeetings().getValue();
        if (meeting != null) {
            newListMeeting.add( meeting );
        }
        this.lMeetings.setValue(newListMeeting);
        this.lMeetingsRef.setValue(newListMeeting);
    }

    public void removeMeeting(int position) throws ParseException {
        List<Meeting> meetingList = getMeetings().getValue();
        meetingList.remove(position);
        this.lMeetings.setValue(meetingList);
        this.lMeetingsRef.setValue(meetingList);
    }

    public void filtre(List<Meeting> meetingList) throws ParseException {
        List<Meeting> filtreListMeeting = getMeetings().getValue();
                this.lMeetings.setValue(meetingList);
    }
    public void deleteFilter(List<Meeting> meetingList) throws ParseException {
        List<Meeting> filtreListMeeting = lMeetingsRef.getValue();
        this.lMeetings.setValue(filtreListMeeting);
    }

}
