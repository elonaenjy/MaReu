package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;
import com.example.mareu.Activity.MeetingMainActivity;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private final List<Meeting> mMeetings = DummyMeetingGenerator.generateMeetings();
    private final List<Guest> mGuests = DummyMeetingGenerator.generateGuests();
    private final List<Room> mRooms = DummyMeetingGenerator.generateRooms();

    @Override
    public List<Meeting> getMeetings() {
        return mMeetings;
    }

    @Override
    public void createMeeting(Meeting meeting) {
        mMeetings.add(meeting);

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMeeting(Meeting meeting) {
        mMeetings.remove(meeting);
    }


}
