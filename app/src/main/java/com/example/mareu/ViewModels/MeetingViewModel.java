package com.example.mareu.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mareu.Model.Meeting;

import java.text.ParseException;
import java.util.List;

public class MeetingViewModel extends ViewModel {

    private MutableLiveData<List<Meeting>> lMeetings;

    public LiveData<List<Meeting>> getMeetings() throws ParseException {
        if(lMeetings == null) {
            lMeetings = new MutableLiveData<List<Meeting>>();
    ///kv        List<Meeting> emptyList = new ArrayList<Meeting>();
    //kv         meetings.setValue(emptyList);
            List<Meeting> listMeetingsRef = Meeting.generateMeetings();
            lMeetings.setValue(listMeetingsRef);
        }
        return lMeetings;
    }

    public void addMeeting(Meeting meeting) throws ParseException {
        List<Meeting> newListMeeting = getMeetings().getValue();
        newListMeeting.add(meeting);
        this.lMeetings.setValue(newListMeeting);
    }

    public void removeMeeting(int position) throws ParseException {
        List<Meeting> meetingList = getMeetings().getValue();
        meetingList.remove(position);
        this.lMeetings.setValue(meetingList);
    }

}
