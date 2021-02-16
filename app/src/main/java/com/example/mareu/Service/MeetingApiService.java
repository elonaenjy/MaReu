package com.example.mareu.Service;

import com.example.mareu.Model.Meeting;

import java.util.List;

public interface MeetingApiService {
    /**
     * Get all the Meeting
     * @return {@link List}
     */
    List<Meeting> getMeetings();
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
