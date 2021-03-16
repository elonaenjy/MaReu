package com.example.mareu;

import com.example.mareu.Activity.AddMeetingActivity;
import com.example.mareu.Model.Meeting;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private long idMeeting, idRoom;
    private String meetingSubject, meetingParticipants, meetingDate, meetingTime ;


    @Test
    public void createMeetingWithSuccess() {
       Meeting meeting100 = new Meeting( 100, 10, "sujet reunion 1","20210213", "141500", "Part1, Part2, Part3");
       AddMeetingActivity.finMeeting( meeting100 );
        assertTrue( AddMeetingActivity..getMeeting().contains(meeting100 ) );

    }
}