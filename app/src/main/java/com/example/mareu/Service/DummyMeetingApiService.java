package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {
    private final List<Meeting> mMeetings = Meeting.generateMeetings();
    private final List<Guest> mGuests = Guest.generateGuests();
    private final List<Room> mRooms = Room.generateRooms();

    @Override
    public List<Meeting> getMeetings() {
        return mMeetings;
    }

    @Override
    public List<Room> getRooms() {
        return mRooms;
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
