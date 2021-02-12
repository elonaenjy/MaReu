package com.example.mareu.Service;

import com.example.mareu.Model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {
    private List<Meeting> meetings = new ArrayList<>();

    @Override
    public List<Meeting> getMeeting() {


        return meetings;
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);

    }
}
