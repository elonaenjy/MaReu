package com.example.mareu;

import com.example.mareu.Model.Meeting;
import com.example.mareu.di.DI;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private MeetingApiService service;
    private long idMeeting, idRoom;
    private String meetingSubject, meetingParticipants, meetingDate, meetingTime ;


    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test

    public void createMeetingWithSuccess() {
       Meeting meeting100 = new Meeting( 100, 10, "sujet reunion 1","20210213", "141500", "Part1, Part2, Part3");
       service.createMeeting( meeting100 );
        assertTrue( service.getMeeting().contains(meeting100 ) );

    }
}