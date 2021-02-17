package com.example.mareu.Service;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.util.List;

public interface MeetingApiService {
    /**
     * Get all the Meeting
     * @return {@link List}
     */
    List<Meeting> getMeetings();

    /**
     * Get all the Rooms
     * @return {@link List}
     */

    List<Room> getRooms();

    /**
     * Create a meeting
     * @param meeting
     */
    void createMeeting(Meeting meeting);

    /**
     * Delete a meeting
     * @param meeting
     */
    void deleteMeeting(Meeting meeting);
}
